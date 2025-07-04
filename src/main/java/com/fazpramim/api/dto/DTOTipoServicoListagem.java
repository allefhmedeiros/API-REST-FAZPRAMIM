package com.fazpramim.api.dto;

import com.fazpramim.api.entities.TipoServico;

public record DTOTipoServicoListagem(
        Long id,
        String nome
) {

    public DTOTipoServicoListagem(TipoServico tipoServico){
        this(tipoServico.getId(), tipoServico.getNome());
    }
}
