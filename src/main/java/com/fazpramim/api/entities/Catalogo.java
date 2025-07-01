package com.fazpramim.api.entities;

import java.time.LocalDateTime;
import java.util.Objects;

public class Catalogo {
    private Long id;
    private LocalDateTime data_cadastro;
    private Double valor_hora;
    private TipoServico tipo_servico;
    private Prestador prestador;

    public Catalogo() {

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Catalogo catalogo = (Catalogo) o;
        return Objects.equals(id, catalogo.id);
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

    public Double getValor_hora() {
        return valor_hora;
    }

    public void setValor_hora(Double valor_hora) {
        this.valor_hora = valor_hora;
    }

    public TipoServico getTipo_servico() {
        return tipo_servico;
    }

    public void setTipo_servico(TipoServico tipo_servico) {
        this.tipo_servico = tipo_servico;
    }

    public Prestador getPrestador() {
        return prestador;
    }

    public void setPrestador(Prestador prestador) {
        this.prestador = prestador;
    }
}
