package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DTOPrestadorAtualizacao(
        @NotNull
        Long id,
        String nome,
        String documento,
        String apresentacao
) {
}
