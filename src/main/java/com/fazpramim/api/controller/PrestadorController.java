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
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import java.util.List;

@RestController
@RequestMapping("prestadores")
public class PrestadorController {

    @Autowired
    private PrestadorRepository repository;

    @PostMapping
    public ResponseEntity cadastrarPrestador(@RequestBody @Valid DTOPrestadorCadastro dados, UriComponentsBuilder uriBuilder){
        var novoPrestador = new Prestador(dados);
        repository.save(novoPrestador);
        var uri = uriBuilder.path("/prestadores/{id}").buildAndExpand(novoPrestador.getId()).toUri();
        return ResponseEntity.created(uri).body(new DTOPrestadorListagem(novoPrestador));
    }

    //Rota --> http://localhost:8080/prestadores?size=5&page=0&sort=nome
    //size --> determina qtd de registros na page.
    //page --> determina a page começando por 0.
    //sort --> determina o campo usado para a classificação dos registros na page.
    //Configuração de paginação básica: @PageableDefault(size = 5, page = 0, sort = {"nome"})

    @GetMapping
    public ResponseEntity<Page<DTOPrestadorListagem>> listarPrestador(@PageableDefault(size = 10, page = 0, sort = {"nome"}) Pageable paginacao){
        var page = repository.findAllByStatusTrue(paginacao).map(DTOPrestadorListagem::new);
        return ResponseEntity.ok(page);
    }

    @PutMapping
    @Transactional
    public ResponseEntity atualizarPrestador(@RequestBody @Valid DTOPrestadorAtualizacao dados){
        var prestador = repository.getReferenceById(dados.id());
        prestador.atualizarInformacoes(dados);
        return ResponseEntity.ok(new DTOPrestadorListagem(prestador));
    }

    @DeleteMapping("/{id}")
    @Transactional
    public ResponseEntity excluirPrestador(@PathVariable Long id){
        var prestador = repository.getReferenceById(id);
        prestador.excluirPrestador();
        return ResponseEntity.noContent().build();
    }

    @GetMapping("/{id}")
    public ResponseEntity detalharPrestador(@PathVariable Long id){
        var prestadorDetalhado = repository.getReferenceById(id);
        return ResponseEntity.ok(new DTOPrestadorListagem(prestadorDetalhado));
    }

}
