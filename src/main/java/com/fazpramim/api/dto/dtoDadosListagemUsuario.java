package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.entities.Usuario;
import jakarta.validation.Valid;
import jakarta.validation.constraints.*;

import java.time.LocalDate;
import java.time.LocalDateTime;

public record dtoDadosListagemUsuario(

        Long id,

        String nome,

        String telefone,

        LocalDate dataNascimento,

        String email,

        String foto,

        String documento,
        dtoSexo sexo,
        Endereco endereco

) {
    public dtoDadosListagemUsuario(Usuario usuario){
        this(usuario.getId(), usuario.getNome(), usuario.getTelefone(), usuario.getDataNascimento(),usuario.getEmail(), usuario.getFoto(), usuario.getDocumento(), usuario.getSexo(), usuario.getEndereco());
    }


}
