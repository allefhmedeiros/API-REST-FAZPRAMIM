package com.fazpramim.api.dto;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fazpramim.api.entities.Catalogo;
import com.fazpramim.api.entities.DetalheServico;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

import java.util.List;

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
