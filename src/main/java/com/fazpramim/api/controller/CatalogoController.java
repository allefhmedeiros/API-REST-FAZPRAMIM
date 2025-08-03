package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOCatalogoAtualizacao;
import com.fazpramim.api.dto.DTOCatalogoCadastro;
import com.fazpramim.api.dto.DTOCatalogoListagem;
import com.fazpramim.api.entities.Catalogo;
import com.fazpramim.api.repository.CatalogoRepository;
import com.fazpramim.api.repository.PrestadorRepository;
import com.fazpramim.api.repository.TipoServicoRepository;
import io.swagger.v3.oas.annotations.security.SecurityRequirement;
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
@RequestMapping("catalogo")
@SecurityRequirement(name = "bearer-key")
public class CatalogoController {
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    public ResponseEntity cadastrarCatalogo(@RequestBody @Valid DTOCatalogoCadastro dados, UriComponentsBuilder uriBuilder){
        var prestador = prestadorRepository.getReferenceById(dados.id_prestador());
        var tipoServico = tipoServicoRepository.getReferenceById(dados.id_servico());

        var catalogoCriado = new Catalogo(dados, prestador, tipoServico);
        catalogoRepository.save(catalogoCriado);

        var uri = uriBuilder.path("/catalogo/{id}").buildAndExpand(catalogoCriado.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOCatalogoListagem(catalogoCriado));
    }

    @GetMapping
    public ResponseEntity<Page<DTOCatalogoListagem>> listarCatalogo(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        var page = catalogoRepository.findAll(paginacao).map(DTOCatalogoListagem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarCatalogo(@RequestBody @Valid DTOCatalogoAtualizacao dados){
        var catalogo = catalogoRepository.getReferenceById(dados.id());
        var tipoServico = tipoServicoRepository.getReferenceById(dados.id_servico());
        catalogo.atualizarInformacoes(dados, tipoServico);
        return ResponseEntity.ok(new DTOCatalogoListagem(catalogo));
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharCatalogo(@PathVariable Long id){
        var catalogo = catalogoRepository.getReferenceById(id);
        return ResponseEntity.ok(new DTOCatalogoListagem(catalogo));
    }



}
