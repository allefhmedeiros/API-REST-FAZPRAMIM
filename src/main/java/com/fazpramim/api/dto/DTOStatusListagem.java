package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Status;

public record DTOStatusListagem(
        Long id,
        String nome
) {
    public DTOStatusListagem(Status status){
        this(status.getId(), status.getNome());
    }
}
