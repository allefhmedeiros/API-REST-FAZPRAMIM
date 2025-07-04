package com.fazpramim.api.entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fazpramim.api.dto.DTOEnderecoCadastro;
import jakarta.persistence.*;

import java.util.Objects;
@Table(name="tbl_endereco")
@Entity(name="Endereco")
public class Endereco {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String logradouro;
    private String numero;
    private String cep;
    private boolean status;
    @ManyToOne
    @JoinColumn(name = "tbl_cliente_id")
    @JsonBackReference
    private Cliente cliente;

    public Endereco() {
    }

    public Endereco(DTOEnderecoCadastro dados, Cliente cliente) {
        this.logradouro = dados.logradouro();
        this.numero = dados.numero();
        this.cep = dados.cep();
        this.status = true;
        this.cliente = cliente;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id);
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

    public String getLogradouro() {
        return logradouro;
    }

    public void setLogradouro(String logradouro) {
        this.logradouro = logradouro;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }
}
