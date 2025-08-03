package com.fazpramim.api.controller;

import com.fazpramim.api.dto.*;
import com.fazpramim.api.entities.Cliente;
import com.fazpramim.api.repository.ClienteRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("clientes")
@SecurityRequirement(name = "bearer-key")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public ResponseEntity cadastrarCliente(@RequestBody @Valid DTOClienteCadastro dados, UriComponentsBuilder uriBuilder){
        var clienteCriado = new Cliente(dados);
        repository.save(clienteCriado);
        var uri = uriBuilder.path("/clientes/{id}").buildAndExpand(clienteCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOClienteListagem(clienteCriado));
    }

    @GetMapping
    public ResponseEntity<Page<DTOClienteListagem>> listarCliente(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page =  repository.findAllByStatusTrue(paginacao).map(DTOClienteListagem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCliente(@RequestBody @Valid DTOClienteAtualizacao dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DTOClienteListagem(cliente));
    }
    //Para o verbo DELETE, é uma boa prática devolver o código 204 - No content.
    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharCliente(@PathVariable Long id){
        var clienteDetalhado = repository.getReferenceById(id);
        return ResponseEntity.ok(new DTOClienteListagem(clienteDetalhado));
    }

}
