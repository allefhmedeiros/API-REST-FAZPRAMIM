package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Prestador;

public record DTOPrestadorListagem(
        Long id,
        String nome,
        String documento,
        boolean status,
        String email,
        String apresentacao
) {
    public DTOPrestadorListagem(Prestador prestador){
        this(prestador.getId(), prestador.getNome(), prestador.getDocumento(), prestador.isStatus(), prestador.getEmail(), prestador.getApresentacao());
    }
}
