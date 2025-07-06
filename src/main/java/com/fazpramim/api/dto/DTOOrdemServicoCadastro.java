package com.fazpramim.api.dto;

import jakarta.validation.constraints.Future;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOOrdemServicoCadastro(
        @Future(message = "A data e hora do agendamento deve ser no futuro")
        LocalDateTime data_agendamento,
        @NotNull(message = "O ID do cliente é obrigatório")
        Long id_cliente,
        @NotNull(message = "O ID do endereco é obrigatório")
        Long id_endereco
) {
}
