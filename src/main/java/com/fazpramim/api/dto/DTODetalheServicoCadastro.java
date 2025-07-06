package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Catalogo;
import com.fazpramim.api.entities.OrdemServico;
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
