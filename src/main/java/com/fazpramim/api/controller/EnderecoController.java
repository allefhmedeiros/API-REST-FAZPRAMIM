package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOEnderecoCadastro;
import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.repository.ClienteRepository;
import com.fazpramim.api.repository.EnderecoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("enderecos")
public class EnderecoController {

    @Autowired
    private EnderecoRepository repository;
    @Autowired
    private ClienteRepository repositoryCliente;

    @PostMapping
    public void cadastrarEndereco(@RequestBody @Valid DTOEnderecoCadastro dados){
        var cliente = repositoryCliente.getReferenceById(dados.id_cliente());
        Endereco endereco = new Endereco(dados, cliente);
        repository.save(endereco);
    }

}
