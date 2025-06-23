package com.fazpramim.api.controller;

import com.fazpramim.api.dto.dtoDadosCadastroMedico;
import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.entities.Usuario;
import com.fazpramim.api.repository.UsuarioRepository;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Notifica o spring que essa classe deve ser inicializada com o projeto.
@RequestMapping("usuarios")
public class UsuarioController {

    @Autowired
    private UsuarioRepository repository;

    @PostMapping
    @Transactional
    public void cadastrarUsuario(@RequestBody @Valid dtoDadosCadastroMedico dados){
        repository.save(new Usuario(dados));
        //System.out.println(dados);
    }

}
