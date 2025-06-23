package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;

public record dtoEndereco (
        @NotBlank
        String rua,
        @NotBlank
        String numero,
        @NotBlank
        String complemento,
        @NotBlank
        @Pattern(regexp = "\\d{8}")
        String cep,
        @NotBlank
        String bairro,
        @NotBlank
        String cidade,
        @NotBlank
        String estado

){
}
