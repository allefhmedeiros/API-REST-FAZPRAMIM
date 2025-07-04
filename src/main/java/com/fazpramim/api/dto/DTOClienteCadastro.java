package com.fazpramim.api.dto;

import jakarta.validation.constraints.*;

import java.time.LocalDate;

public record DTOClienteCadastro(
        @NotBlank(message = "O nome é obrigatório.")
        @Pattern(
                regexp = "^[A-ZÀ-Úa-zà-ú]+(\\s+[A-ZÀ-Úa-zà-ú]+)+$",
                message = "Informe o nome completo (nome e sobrenome)."
        )
        String nome,
        @NotBlank(message = "O e-mail é obrigatório.")
        @Email(message = "Formato de e-mail inválido.")
        String email,
        @Past(message = "A data de nascimento deve ser uma data no passado")
        LocalDate data_nascimento,
        @NotBlank(message = "A senha é obrigatória.")
        @Size(min = 8, max = 20, message = "A senha deve ter entre 8 e 20 caracteres.")
        @Pattern(
                regexp = "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$",
                message = "A senha deve conter ao menos uma letra maiúscula, uma minúscula, um número e um caractere especial."
        )
        String senha
) {
}
