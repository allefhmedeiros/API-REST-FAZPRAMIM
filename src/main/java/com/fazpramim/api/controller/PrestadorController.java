package com.fazpramim.api.controller;

import com.fazpramim.api.dto.DTOPrestadorAtualizacao;
import com.fazpramim.api.dto.DTOPrestadorCadastro;
import com.fazpramim.api.dto.DTOPrestadorListagem;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.repository.PrestadorRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
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

    //Rota --> http://localhost:8080/prestadores?size=5&page=0&sort=nome
    //size --> determina qtd de registros na page.
    //page --> determina a page começando por 0.
    //sort --> determina o campo usado para a classificação dos registros na page.
    //Configuração de paginação básica: @PageableDefault(size = 5, page = 0, sort = {"nome"})

    @GetMapping
    public Page<DTOPrestadorListagem> listarPrestador(@PageableDefault(size = 5, page = 0, sort = {"nome"}) Pageable paginacao){
        return repository.findAll(paginacao).map(DTOPrestadorListagem::new);
    }

    @PutMapping
    @Transactional
    public void atualizarPrestador(@RequestBody @Valid DTOPrestadorAtualizacao dados){
        var medico = repository.getReferenceById(dados.id());
        medico.atualizarInformacoes(dados);
    }

}
