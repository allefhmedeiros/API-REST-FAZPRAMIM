package com.fazpramim.api.entities;

import com.fazpramim.api.dto.DTOCadastroFornecedor;
import jakarta.persistence.*;

import java.util.Objects;

@Table(name="tbl_prestador")
@Entity(name="Prestador")
public class Prestador {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nome;
    private String documento;
    private boolean status;
    private String email;
    private String senha;
    private String apresentacao;

    public Prestador() {
    }

    public Prestador(DTOCadastroFornecedor dados) {
        this.nome = dados.nome();
        this.documento = dados.documento();
        this.status = dados.status();
        this.email = dados.email();
        this.senha = dados.senha();
        this.apresentacao = dados.apresentacao();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Prestador prestador = (Prestador) o;
        return Objects.equals(id, prestador.id);
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

    public String getDocumento() {
        return documento;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public String getApresentacao() {
        return apresentacao;
    }

    public void setApresentacao(String apresentacao) {
        this.apresentacao = apresentacao;
    }
}
