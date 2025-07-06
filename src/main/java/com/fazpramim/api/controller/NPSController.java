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
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("nps")
public class NPSController {

    @Autowired
    private NPSRepository npsRepository;

    @Autowired
    private OrdemServicoRepository ordemServicoRepository;

    @PostMapping
    public void cadastrarNps(@RequestBody @Valid DTONpsCadastro dados){
        var ordemServico = ordemServicoRepository.getReferenceById(dados.id_ordem_servico());
        npsRepository.save(new Nps(dados, ordemServico));
    }

    @GetMapping
    public Page<DTONpsListagem> listarNps(@PageableDefault(size = 10, page = 0) Pageable paginacao){
        return npsRepository.findAll(paginacao).map(DTONpsListagem::new);
    }

}
