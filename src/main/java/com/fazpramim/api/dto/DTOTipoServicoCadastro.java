package com.fazpramim.api.dto;

import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DTOTipoServicoCadastro(
        @Size(min = 3, max = 50, message = "O nome do serviço deve ter entre 3 e 50 caracteres")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ0-9\\s'-]{3,50}$", message = "Nome do serviço inválido. Use apenas letras, números, espaços, hífen ou apóstrofo")
        String nome
) {
}
