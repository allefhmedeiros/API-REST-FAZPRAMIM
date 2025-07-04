package com.fazpramim.api.entities;

import com.fazpramim.api.dto.DTOClienteAtualizacao;
import com.fazpramim.api.dto.DTOClienteCadastro;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Table(name="tbl_cliente")
@Entity(name="Cliente")
public class Cliente {
    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private LocalDate data_nascimento;
    private LocalDateTime data_cadastro;
    private String senha;
    private boolean status;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Endereco> enderecos = new ArrayList<>();

    public Cliente() {
    }

    public Cliente(DTOClienteCadastro dados) {
        LocalDateTime dataAtual = LocalDateTime.now();
        this.nome = dados.nome();
        this.status = true;
        this.email = dados.email();
        this.senha = dados.senha();
        this.data_nascimento = dados.data_nascimento();
        this.data_cadastro = dataAtual;
    }



    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id);
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

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public LocalDate getData_nascimento() {
        return data_nascimento;
    }

    public void setData_nascimento(LocalDate data_nascimento) {
        this.data_nascimento = data_nascimento;
    }

    public LocalDateTime getData_cadastro() {
        return data_cadastro;
    }

    public void setData_cadastro(LocalDateTime data_cadastro) {
        this.data_cadastro = data_cadastro;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public List<Endereco> getEnderecos() {
        return enderecos;
    }

    public void setEnderecos(List<Endereco> enderecos) {
        this.enderecos = enderecos;
    }

    public void atualizarInformacoes(DTOClienteAtualizacao dados) {
        if(dados.nome() != null){
            this.nome = dados.nome();
        }
        if(dados.data_nascimento() != null){
            this.data_nascimento = dados.data_nascimento();
        }
    }

    public void excluirCliente() {
        this.status = false;
    }
}
