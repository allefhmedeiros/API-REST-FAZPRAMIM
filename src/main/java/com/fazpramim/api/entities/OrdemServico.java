package com.fazpramim.api.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

public class OrdemServico {
    private Long id;
    private LocalDateTime data_cadastro;
    private LocalDateTime data_agendamento;
    private Double valor_total;
    private Status status;
    private Cliente cliente;
    private Endereco endereco;
    private List<DetalheServico> detalhes;

    public OrdemServico() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        OrdemServico that = (OrdemServico) o;
        return Objects.equals(id, that.id);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public LocalDateTime getData_agendamento() {
        return data_agendamento;
    }

    public void setData_agendamento(LocalDateTime data_agendamento) {
        this.data_agendamento = data_agendamento;
    }

    public Double getValor_total() {
        return valor_total;
    }

    public void setValor_total(Double valor_total) {
        this.valor_total = valor_total;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public List<DetalheServico> getDetalhes() {
        return detalhes;
    }

    public void setDetalhes(List<DetalheServico> detalhes) {
        this.detalhes = detalhes;
    }
}
