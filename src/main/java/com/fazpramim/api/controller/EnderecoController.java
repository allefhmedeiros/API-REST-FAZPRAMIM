package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOEnderecoCadastro;
import com.fazpramim.api.dto.DTOEnderecoListagem;
import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.repository.ClienteRepository;
import com.fazpramim.api.repository.EnderecoRepository;
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
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private ClienteRepository repositoryCliente;

    @PostMapping
    public ResponseEntity cadastrarEndereco(@RequestBody @Valid DTOEnderecoCadastro dados, UriComponentsBuilder uriBuilder){
        var cliente = repositoryCliente.getReferenceById(dados.id_cliente());
        Endereco endereco = new Endereco(dados, cliente);
        repository.save(endereco);
        var uri = uriBuilder.path("/enderecos/{id}").buildAndExpand(endereco.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOEnderecoListagem(endereco));
    }

    @GetMapping
    public ResponseEntity<Page<DTOEnderecoListagem>> listarEnderecos(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        var page = repository.findAllByStatusTrue(paginacao).map(DTOEnderecoListagem::new);
        return ResponseEntity.ok(page);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirEndereco(@PathVariable Long id){
        var endereco = repository.getReferenceById(id);
        endereco.excluirEndereco();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharEndereco(@PathVariable Long id){
        var enderecoDetalhado = repository.getReferenceById(id);
        return ResponseEntity.ok(new DTOEnderecoListagem(enderecoDetalhado));
    }

}
