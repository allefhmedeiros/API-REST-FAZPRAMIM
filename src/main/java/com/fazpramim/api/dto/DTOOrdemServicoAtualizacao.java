package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOOrdemServicoAtualizacao(
        @NotNull
        Long id,
        @NotNull
        LocalDateTime data_agendamento,
        Double valor_total,
        @NotNull
        Long id_status,
        @NotNull
        Long id_cliente,
        @NotNull
        Long id_endereco
) {
}
