package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOPrestadorCadastro;
import com.fazpramim.api.dto.DTOTipoServicoCadastro;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.entities.TipoServico;
import com.fazpramim.api.repository.TipoServicoRepository;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("tiposervicos")
public class TipoServicoController {

    @Autowired
    private TipoServicoRepository tipoServicoRepository;

    @PostMapping
    public void cadastrarTipoServico(@RequestBody @Valid DTOTipoServicoCadastro dados){
        tipoServicoRepository.save(new TipoServico(dados));
    }

}
