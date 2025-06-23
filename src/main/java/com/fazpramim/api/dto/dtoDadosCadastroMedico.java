package com.fazpramim.api.dto;

import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record dtoDadosCadastroMedico (
        @NotBlank(message = "O nome é obrigatório para cadastro de usuários")
        String nome,
        @Pattern(regexp = "^(\\(?\\d{2}\\)?\\s?)?(9\\d{4}|[2-9]\\d{3})-?\\d{4}$", message = "Telefone inválido. Use o formato (99) 99999-9999 ou (99) 9999-9999")
        String telefone,
        @Past(message = "A data de nascimento deve ser no passado")
        @NotNull(message = "Data de nascimento é obrigatória")
        LocalDate dataNascimento,
        @NotBlank(message = "Email é obrigatório")
        @Email(message = "Email deve ser válido")
        String email,
        @NotBlank(message = "Senha é obrigatória")
        @Size(min = 6, max = 20, message = "Senha deve ter entre 6 e 20 caracteres")
        String senha,
        @NotBlank(message = "Link da foto não pode ser enviaod em branco")
        String foto,
        @NotNull(message = "Data de cadastro é obrigatória")
        LocalDateTime dataCadastro,
        @NotBlank
        String documento,
        @NotNull(message = "O valor booleano deve ser informado")
        boolean status,
        @NotNull(message = "O sexo deve ser informado")
        dtoSexo sexo,
        @NotNull
        @Valid
        dtoEndereco endereco
    ){

}
