package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Cliente;
import com.fazpramim.api.entities.Endereco;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record DTOClienteListagemServico(
        Long id,
        String nome,
        String email,
        LocalDate data_nascimento,
        LocalDateTime data_cadastro
) {
    public DTOClienteListagemServico(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getData_nascimento(), cliente.getData_cadastro());
    }
}
