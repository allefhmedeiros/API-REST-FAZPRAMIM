package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOPrestadorCadastro;
import com.fazpramim.api.dto.DTOPrestadorListagem;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.repository.PrestadorRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorRepository repository;

    @PostMapping
    public void cadastrarPrestador(@RequestBody @Valid DTOPrestadorCadastro dados){
        repository.save(new Prestador(dados));
    }

    @GetMapping
    public List<DTOPrestadorListagem> listarPrestador(){
        return repository.findAll().stream().map(DTOPrestadorListagem::new).toList();
    }

}
