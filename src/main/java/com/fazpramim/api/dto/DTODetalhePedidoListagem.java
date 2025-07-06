package com.fazpramim.api.dto;

import com.fazpramim.api.entities.DetalheServico;


public record DTODetalhePedidoListagem(
        Long id,
        Integer qtd_horas,
        Double sub_total,
        DTOCatalogoListagem catalogo
) {
    public DTODetalhePedidoListagem(DetalheServico detalheServico) {
        this(detalheServico.getId(), detalheServico.getQtd_horas(), detalheServico.getSub_total(), new DTOCatalogoListagem(detalheServico.getCatalogo()));
    }
}
