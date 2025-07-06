package com.fazpramim.api.entities;

import com.fazpramim.api.dto.DTOStatusCadastro;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="tbl_status")
@Entity(name="Status")

public class Status {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;

    public Status() {
    }

    public Status(DTOStatusCadastro dados) {
        this.nome = dados.nome();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Status status = (Status) o;
        return Objects.equals(id, status.id);
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
