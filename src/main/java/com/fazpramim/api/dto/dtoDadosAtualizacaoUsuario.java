package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotNull;

// A regra de negócio define que os únicos campos que podem ser alterados são nome, telefone, documento.
public record dtoDadosAtualizacaoUsuario(
        @NotNull
        Long id,
        String nome,
        String telefone,
        String documento) {
}
