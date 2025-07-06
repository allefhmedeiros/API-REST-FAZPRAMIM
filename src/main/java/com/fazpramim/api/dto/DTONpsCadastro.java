package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotNull;


public record DTONpsCadastro(
        @NotNull
        Integer nota,
        @NotNull
        String comentario,
        @NotNull
        Long id_ordem_servico
) {
}
