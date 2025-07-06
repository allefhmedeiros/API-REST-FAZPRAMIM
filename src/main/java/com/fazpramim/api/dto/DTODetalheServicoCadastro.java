package com.fazpramim.api.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;

public record DTODetalheServicoCadastro(
        @NotNull
        @Min(1)
        Integer qtd_horas,
        @NotNull
        Long id_catalogo,
        @NotNull
        Long id_ordem_servico
) {
}
