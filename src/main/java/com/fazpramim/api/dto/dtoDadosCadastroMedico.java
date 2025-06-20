package com.fazpramim.api.dto;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record dtoDadosCadastroMedico (
        String nome,
        String telefone,
        LocalDate dataNascimento,
        String email,
        String senha,
        String foto,
        LocalDateTime dataCadastro,
        String documento,
        boolean status,
        dtoSexo sexo,
        dtoEndereco endereco
    ){

}
