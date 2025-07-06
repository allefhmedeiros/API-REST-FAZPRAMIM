package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Nps;

import java.time.LocalDateTime;

public record DTONpsListagem(
        Long id,
        Integer nota,
        LocalDateTime data,
        String comentario,
        DTOOrdemServicoListagem ordem_servico
) {
    public DTONpsListagem(Nps nps){
        this(nps.getId(), nps.getNota(), nps.getData(), nps.getComentario(), new DTOOrdemServicoListagem(nps.getOrdem_servico()));
    }
}
