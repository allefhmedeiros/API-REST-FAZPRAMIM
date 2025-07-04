package com.fazpramim.api.entities;

import com.fazpramim.api.dto.DTOTipoServicoCadastro;
import jakarta.persistence.*;

import java.util.Objects;
@Table(name="tbl_TIPO_SERVICO")
@Entity(name="TipoServico")
public class TipoServico {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public TipoServico() {
    }

    public TipoServico(DTOTipoServicoCadastro dados) {
        this.nome = dados.nome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        TipoServico that = (TipoServico) o;
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

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }
}
