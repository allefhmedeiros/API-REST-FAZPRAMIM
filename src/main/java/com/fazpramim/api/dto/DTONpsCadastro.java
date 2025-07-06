package com.fazpramim.api.dto;

import com.fazpramim.api.entities.OrdemServico;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTONpsCadastro(
        @NotNull
        Integer nota,
        @NotNull
        String comentario,
        @NotNull
        Long id_ordem_servico
) {
}
