package com.fazpramim.api.entities;

import java.util.Objects;

public class DetalheServico {
    private Long id;
    private Integer qtd_horas;
    private Double sub_total;
    private Catalogo catalogo;
    private OrdemServico ordem_servico;

    public DetalheServico() {
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DetalheServico that = (DetalheServico) o;
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

    public Integer getQtd_horas() {
        return qtd_horas;
    }

    public void setQtd_horas(Integer qtd_horas) {
        this.qtd_horas = qtd_horas;
    }

    public Double getSub_total() {
        return sub_total;
    }

    public void setSub_total(Double sub_total) {
        this.sub_total = sub_total;
    }

    public Catalogo getCatalogo() {
        return catalogo;
    }

    public void setCatalogo(Catalogo catalogo) {
        this.catalogo = catalogo;
    }

    public OrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    public void setOrdem_servico(OrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }
}
