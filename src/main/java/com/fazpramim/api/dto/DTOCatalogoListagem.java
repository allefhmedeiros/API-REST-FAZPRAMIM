package com.fazpramim.api.dto;

import com.fazpramim.api.entities.Catalogo;
import com.fazpramim.api.entities.Prestador;
import com.fazpramim.api.entities.TipoServico;

import java.time.LocalDateTime;

public record DTOCatalogoListagem(
        Long id,
        LocalDateTime data_cadastro,
        Double valor_hora,
        TipoServico tipo_servico,
        DTOPrestadorListagem prestador
) {
    public DTOCatalogoListagem(Catalogo catalogo){
        this(catalogo.getId(), catalogo.getData_cadastro(), catalogo.getValor_hora(), catalogo.getTipo_servico(), new DTOPrestadorListagem(catalogo.getPrestador()));
    }
}
