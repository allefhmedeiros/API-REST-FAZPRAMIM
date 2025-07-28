package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOClienteListagem;
import com.fazpramim.api.dto.DTOStatusCadastro;
import com.fazpramim.api.dto.DTOStatusListagem;
import com.fazpramim.api.entities.Status;
import com.fazpramim.api.repository.StatusRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("status")
public class StatusController {

    @Autowired
    private StatusRepository statusRepository;

    @PostMapping
    public ResponseEntity cadastrarStatus(@RequestBody @Valid DTOStatusCadastro dados, UriComponentsBuilder uriBuilder){
        var novoStatus = new Status(dados);
        statusRepository.save(novoStatus);
        var uri = uriBuilder.path("/status/{id}").buildAndExpand(novoStatus.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOStatusListagem(novoStatus));
    }

    @GetMapping
    public ResponseEntity<Page<DTOStatusListagem>> listarStatus(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page = statusRepository.findAll(paginacao).map(DTOStatusListagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharStatus(@PathVariable Long id){
        var statusDetalhado = statusRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTOStatusListagem(statusDetalhado));
    }

}
