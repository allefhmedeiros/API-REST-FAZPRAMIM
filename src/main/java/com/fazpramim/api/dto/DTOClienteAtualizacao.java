package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDate;

public record DTOClienteAtualizacao(
        @NotNull
        Long id,
        String nome,
        LocalDate data_nascimento
) {
}
