package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOStatusCadastro;
import com.fazpramim.api.dto.DTOStatusListagem;
import com.fazpramim.api.entities.Status;
import com.fazpramim.api.repository.StatusRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping
    public void cadastrarStatus(@RequestBody @Valid DTOStatusCadastro dados){
        statusRepository.save(new Status(dados));
    }

    @GetMapping
    public Page<DTOStatusListagem> listarStatus(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return statusRepository.findAll(paginacao).map(DTOStatusListagem::new);
    }

}
