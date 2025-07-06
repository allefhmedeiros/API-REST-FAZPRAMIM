package com.fazpramim.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fazpramim.api.dto.DTONpsCadastro;
import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.Objects;
@Table(name="tbl_nps")
@Entity(name="Nps")
public class Nps {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private Integer nota;
    private LocalDateTime data;
    private String comentario;
    @ManyToOne
    @JoinColumn(name = "tbl_ordem_servico_id")
    @JsonBackReference
    private OrdemServico ordem_servico;

    public Nps() {
    }

    public Nps(DTONpsCadastro dados, OrdemServico ordemServico) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.nota = dados.nota();
        this.data = dataAtual;
        this.comentario = dados.comentario();
        this.ordem_servico = ordemServico;

    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Nps nps = (Nps) o;
        return Objects.equals(id, nps.id);
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

    public int getNota() {
        return nota;
    }

    public void setNota(int nota) {
        this.nota = nota;
    }

    public LocalDateTime getData() {
        return data;
    }

    public void setData(LocalDateTime data) {
        this.data = data;
    }

    public String getComentario() {
        return comentario;
    }

    public void setComentario(String comentario) {
        this.comentario = comentario;
    }

    public OrdemServico getOrdem_servico() {
        return ordem_servico;
    }

    public void setOrdem_servico(OrdemServico ordem_servico) {
        this.ordem_servico = ordem_servico;
    }
}
