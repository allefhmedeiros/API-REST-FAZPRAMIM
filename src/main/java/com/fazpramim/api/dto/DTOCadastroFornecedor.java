package com.fazpramim.api.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;

public record DTOCadastroFornecedor(
        @NotBlank(message = "O nome é obrigatório.")
        @Pattern(
                regexp = "^[A-ZÀ-Úa-zà-ú]+(\\s+[A-ZÀ-Úa-zà-ú]+)+$",
                message = "Informe o nome completo (nome e sobrenome)."
        )
        String nome,
        @NotBlank(message = "O documento é obrigatório.")
        @Size(min = 11, max = 14, message = "O documento deve ter entre 11 e 14 dígitos.")
        @Pattern(regexp = "\\d+", message = "O documento deve conter apenas números.")
        String documento,
        boolean status,
        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Formato de e-mail inválido.")
        String email,
        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula, um número e um caractere especial."
        )
        String senha,
        @NotBlank(message = "A apresentação é obrigatória.")
        @Size(min = 10, max = 1000, message = "A apresentação deve ter entre 10 e 1000 caracteres.")
        String apresentacao
) {
}
