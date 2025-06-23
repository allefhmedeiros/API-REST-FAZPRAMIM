package com.fazpramim.api.controller;

import com.fazpramim.api.dto.dtoDadosCadastroUsuario;
import com.fazpramim.api.dto.dtoDadosListagemUsuario;
import com.fazpramim.api.entities.Usuario;
import com.fazpramim.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController  //Notifica o spring que essa classe deve ser inicializada com o projeto.
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid dtoDadosCadastroUsuario dados){
        repository.save(new Usuario(dados));
        //System.out.println(dados);
    }

    @GetMapping
    public List<dtoDadosListagemUsuario> listarUsuarios(){
        return repository.findAll().stream().map(dtoDadosListagemUsuario::new).toList();
    }

}
