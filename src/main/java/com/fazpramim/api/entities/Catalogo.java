package com.fazpramim.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fazpramim.api.dto.DTOCatalogoAtualizacao;
import com.fazpramim.api.dto.DTOCatalogoCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;

@Table(name="tbl_catalogo")
@Entity(name="Catalogo")
public class Catalogo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private LocalDateTime data_cadastro;
    private Double valor_hora;
    @ManyToOne
    @JoinColumn(name = "tbl_tipo_servico_id")
    @JsonBackReference
    private TipoServico tipo_servico;
    @ManyToOne
    @JoinColumn(name = "tbl_prestador_id")
    @JsonBackReference
    private Prestador prestador;

    public Catalogo() {

    }

    public Catalogo(DTOCatalogoCadastro dados, Prestador prestador, TipoServico tipoServico) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.data_cadastro = dataAtual;
        this.valor_hora = dados.valor_hora();
        this.prestador = prestador;
        this.tipo_servico = tipoServico;
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

    public void atualizarInformacoes(DTOCatalogoAtualizacao dados, TipoServico tipoServico) {
        if(dados.valor_hora() != null){
            this.valor_hora = dados.valor_hora();
        }
        if(tipoServico != null){
            this.tipo_servico = tipoServico;
        }
    }
}
