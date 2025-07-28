package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTONpsCadastro;
import com.fazpramim.api.dto.DTONpsListagem;
import com.fazpramim.api.entities.Nps;
import com.fazpramim.api.repository.NPSRepository;
import com.fazpramim.api.repository.OrdemServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("nps")
public class NPSController {

    @Autowired
    private NPSRepository npsRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    public ResponseEntity cadastrarNps(@RequestBody @Valid DTONpsCadastro dados, UriComponentsBuilder uriBuilder){
        var ordemServico = ordemServicoRepository.getReferenceById(dados.id_ordem_servico());
        var novoNps = new Nps(dados, ordemServico);
        npsRepository.save(novoNps);
        var uri = uriBuilder.path("/nps/{id}").buildAndExpand(novoNps.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTONpsListagem(novoNps));
    }

    @GetMapping
    public ResponseEntity<Page<DTONpsListagem>> listarNps(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        var page =  npsRepository.findAll(paginacao).map(DTONpsListagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharNps(@PathVariable Long id){
        var npsDetalhado = npsRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTONpsListagem(npsDetalhado));
    }

}
