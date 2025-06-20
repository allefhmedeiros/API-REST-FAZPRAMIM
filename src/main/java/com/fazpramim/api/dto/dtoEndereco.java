package com.fazpramim.api.dto;

import java.time.LocalDateTime;

public record dtoEndereco (
        String rua,
        String numero,
        String complemento,
        String cep,
        String bairro,
        String cidade,
        String estado

){
}
