package com.fazpramim.api.dto;

import com.fazpramim.api.entities.*;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

public record DTOOrdemServicoListagem(
        Long id,
        LocalDateTime data_cadastro,
        LocalDateTime data_agendamento,
        Double valor_total,
        DTOStatusListagem status,
        DTOClienteListagemServico cliente,
        DTOEnderecoListagem endereco,
        List<DTODetalhePedidoListagem> detalhePedido

) {
    public DTOOrdemServicoListagem(OrdemServico ordemServico){
        this(ordemServico.getId(), ordemServico.getData_cadastro(), ordemServico.getData_agendamento(), ordemServico.getValor_total(), new DTOStatusListagem(ordemServico.getStatus()), new DTOClienteListagemServico(ordemServico.getCliente()), new DTOEnderecoListagem(ordemServico.getEndereco()), ordemServico.getDetalhes()
                .stream()
                .map(DTODetalhePedidoListagem::new)
                .collect(Collectors.toList()));
    }
}
