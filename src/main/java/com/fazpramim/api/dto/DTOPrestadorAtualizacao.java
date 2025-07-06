package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotNull;

public record DTOPrestadorAtualizacao(
        @NotNull
        Long id,
        String nome,
        String documento,
        String apresentacao
) {
}
