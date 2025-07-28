package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOClienteListagem;
import com.fazpramim.api.dto.DTOTipoServicoCadastro;
import com.fazpramim.api.dto.DTOTipoServicoListagem;
import com.fazpramim.api.entities.TipoServico;
import com.fazpramim.api.repository.TipoServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

@RestController
@RequestMapping("tiposervicos")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    public ResponseEntity cadastrarTipoServico(@RequestBody @Valid DTOTipoServicoCadastro dados, UriComponentsBuilder uriBuilder){
        var servicoCriadoTp = new TipoServico(dados);
        tipoServicoRepository.save(servicoCriadoTp);
        var uri = uriBuilder.path("/tiposervicos/{id}").buildAndExpand(servicoCriadoTp.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOTipoServicoListagem(servicoCriadoTp));
    }

    @GetMapping
    public ResponseEntity<Page<DTOTipoServicoListagem>> listarTipoServicos(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page =  tipoServicoRepository.findAll(paginacao).map(DTOTipoServicoListagem::new);
        return ResponseEntity.ok(page);
    }

    @GetMapping("/{id}")
    public ResponseEntity tipoServicoCliente(@PathVariable Long id){
        var tipoServicoDetalhado = tipoServicoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTOTipoServicoListagem(tipoServicoDetalhado));
    }

}
