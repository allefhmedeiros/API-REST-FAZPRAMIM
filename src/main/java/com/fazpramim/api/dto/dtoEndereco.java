package com.fazpramim.api.dto;

public record dtoEndereco (
        String rua,
        String numero,
        String complemento,
        String cep,
        String bairro,
        String cidade,
        String estado,
        String dataCadastro,
        boolean status

){
}
