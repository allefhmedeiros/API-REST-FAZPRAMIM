package com.fazpramim.api.dto;

public record dtoDadosCadastroMedico (
        String nome,
        String telefone,
        String dataNascimento,
        String email,
        String senha,
        String foto,
        String dataCadastro,
        String documento,
        boolean status,
        dtoSexo sexo,
        dtoEndereco endereco
    ){

}
