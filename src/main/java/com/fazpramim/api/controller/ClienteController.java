package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOClienteCadastro;
import com.fazpramim.api.dto.DTOPrestadorCadastro;
import com.fazpramim.api.entities.Cliente;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.repository.ClienteRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("clientes")
public class ClienteController {

    @Autowired
    private ClienteRepository repository;

    @PostMapping
    public void cadastrarCliente(@RequestBody @Valid DTOClienteCadastro dados){
        repository.save(new Cliente(dados));
    }

}
