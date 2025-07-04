package com.fazpramim.api.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DTOEnderecoCadastro(
        @NotBlank(message = "O logradouro é obrigatório")
        @Size(min = 3, max = 100, message = "O logradouro deve ter entre 3 e 100 caracteres")
        @Pattern(regexp = "^[A-Za-zÀ-ÿ0-9\\s,\\.\\-ºª]+$", message = "O logradouro contém caracteres inválidos")
        String logradouro,
        @NotBlank(message = "O número do endereço é obrigatório")
        @Size(min = 1, max = 10, message = "O número deve ter entre 1 e 10 caracteres")
        @Pattern(regexp = "^[0-9A-Za-z\\-]+$", message = "O número deve conter apenas letras, números ou hífen")
        String numero,
        @NotBlank(message = "O CEP é obrigatório")
        @Pattern(regexp = "^\\d{8}$", message = "O CEP deve conter exatamente 8 dígitos")
        String cep,
        @NotNull(message = "O id do cliente é obrigatório")
        Long id_cliente
) {
}
