package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOCadastroFornecedor;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.repository.PrestadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorRepository repository;

    @PostMapping
    public void cadastrarPrestador(@RequestBody @Valid DTOCadastroFornecedor dados){
        repository.save(new Prestador(dados));
    }

}
