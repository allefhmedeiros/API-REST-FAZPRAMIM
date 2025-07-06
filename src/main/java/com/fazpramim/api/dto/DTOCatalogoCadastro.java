package com.fazpramim.api.dto;

import jakarta.validation.constraints.DecimalMin;
import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotNull;

import java.time.LocalDateTime;

public record DTOCatalogoCadastro(
        //LocalDateTime data_cadastro
        @DecimalMin(value = "0.0", inclusive = false, message = "O valor deve ser maior que zero.")
        @Max(value = 1000000, message = "O valor não pode ser maior que 1 milhão.")
        Double valor_hora,
        @NotNull(message = "O id do serviço prestado é obrigatório")
        Long id_servico,
        @NotNull(message = "O id do prestador é obrigatório")
        Long  id_prestador
) {
}
