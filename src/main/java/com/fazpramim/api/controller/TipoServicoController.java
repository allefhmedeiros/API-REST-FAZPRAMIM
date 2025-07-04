package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOTipoServicoCadastro;
import com.fazpramim.api.dto.DTOTipoServicoListagem;
import com.fazpramim.api.entities.TipoServico;
import com.fazpramim.api.repository.TipoServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("tiposervicos")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    public void cadastrarTipoServico(@RequestBody @Valid DTOTipoServicoCadastro dados){
        tipoServicoRepository.save(new TipoServico(dados));
    }

    @GetMapping
    public Page<DTOTipoServicoListagem> listarTipoServicos(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        return tipoServicoRepository.findAll(paginacao).map(DTOTipoServicoListagem::new);
    }

}
