package com.fazpramim.api.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/teste")
public class TesteImplementacao {
    @GetMapping
    public String testeImplementacao(){
        return "Teste de implementação de serviços e funcionamento de infra";
    }
}
