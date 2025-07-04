package com.fazpramim.api.dto;


import com.fazpramim.api.entities.Endereco;


public record DTOEnderecoListagem(
        Long id,
        String logradouro,
        String numero,
        String cep,
        boolean status
) {
    public DTOEnderecoListagem(Endereco endereco){
        this(endereco.getId(), endereco.getLogradouro(), endereco.getNumero(), endereco.getCep(), endereco.getCliente().isStatus());
    }
}
