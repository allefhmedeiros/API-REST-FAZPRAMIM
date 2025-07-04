package com.fazpramim.api.controller;

import com.fazpramim.api.dto.*;
import com.fazpramim.api.entities.Cliente;
import com.fazpramim.api.repository.ClienteRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public void cadastrarCliente(@RequestBody @Valid DTOClienteCadastro dados){
        repository.save(new Cliente(dados));
    }

    @GetMapping
    public Page<DTOClienteListagem> listarCliente(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAllByStatusTrue(paginacao).map(DTOClienteListagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCliente(@RequestBody @Valid DTOClienteAtualizacao dados){
        var cliente = repository.getReferenceById(dados.id());
        cliente.atualizarInformacoes(dados);
    }

    @DeleteMapping("/{id}")
    @Transactional
    public void excluirCliente(@PathVariable Long id){
        var cliente = repository.getReferenceById(id);
        cliente.excluirCliente();
    }

}
