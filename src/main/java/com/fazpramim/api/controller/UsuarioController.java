package com.fazpramim.api.controller;

import com.fazpramim.api.dto.dtoDadosCadastroMedico;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController  //Notifica o spring que essa classe deve ser inicializada com o projeto.
@RequestMapping("usuarios")
public class UsuarioController {

    @PostMapping
    public void cadastrarUsuario(@RequestBody dtoDadosCadastroMedico dados){
        System.out.println(dados);
    }

}
