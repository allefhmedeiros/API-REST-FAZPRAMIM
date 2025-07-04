package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOCatalogoAtualizacao;
import com.fazpramim.api.dto.DTOCatalogoCadastro;
import com.fazpramim.api.dto.DTOCatalogoListagem;
import com.fazpramim.api.entities.Catalogo;
import com.fazpramim.api.repository.CatalogoRepository;
import com.fazpramim.api.repository.PrestadorRepository;
import com.fazpramim.api.repository.TipoServicoRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("catalogo")
public class CatalogoController {
    @Autowired
    private CatalogoRepository catalogoRepository;

    @Autowired
    private PrestadorRepository prestadorRepository;

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    public void cadastrarCatalogo(@RequestBody @Valid DTOCatalogoCadastro dados){
        var prestador = prestadorRepository.getReferenceById(dados.id_prestador());
        var tipoServico = tipoServicoRepository.getReferenceById(dados.id_servico());
        catalogoRepository.save(new Catalogo(dados, prestador, tipoServico));
    }

    @GetMapping
    public Page<DTOCatalogoListagem> listarCatalogo(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return catalogoRepository.findAll(paginacao).map(DTOCatalogoListagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizarCatalogo(@RequestBody @Valid DTOCatalogoAtualizacao dados){
        var catalogo = catalogoRepository.getReferenceById(dados.id());
        var tipoServico = tipoServicoRepository.getReferenceById(dados.id_servico());
        catalogo.atualizarInformacoes(dados, tipoServico);
    }

}
