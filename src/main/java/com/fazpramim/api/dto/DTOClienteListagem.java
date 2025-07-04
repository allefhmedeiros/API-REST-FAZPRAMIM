package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Cliente;
import com.fazpramim.api.entities.Endereco;
import com.fazpramim.api.entities.Prestador;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

public record DTOClienteListagem(
        Long id,
        String nome,
        String email,
        LocalDate data_nascimento,
        LocalDateTime data_cadastro,
        List<Endereco> enderecos
) {
    public DTOClienteListagem(Cliente cliente){
        this(cliente.getId(), cliente.getNome(), cliente.getEmail(), cliente.getData_nascimento(), cliente.getData_cadastro(), cliente.getEnderecos());
    }
}
