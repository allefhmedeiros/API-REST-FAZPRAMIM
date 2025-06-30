package com.fazpramim.api.entities;

import com.fazpramim.api.dto.dtoDadosAtualizacaoUsuario;
import com.fazpramim.api.dto.dtoDadosCadastroUsuario;
import com.fazpramim.api.dto.dtoSexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Table(name = "tbl_usuarios")
@Entity(name = "Usuario")
@Getter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")

public class Usuario {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String telefone;
    private LocalDate dataNascimento;
    private String email;
    private String senha;
    private String foto;
    private LocalDateTime dataCadastro;
    private String documento;
    boolean status;
    @Enumerated(EnumType.STRING)
    private dtoSexo sexo;
    @Embedded
    private Endereco endereco;

    public Usuario(dtoDadosCadastroUsuario dados) {
        this.nome = dados.nome();
        this.telefone = dados.telefone();
        this.dataNascimento = dados.dataNascimento();
        this.email = dados.email();
        this.senha = dados.senha();
        this.foto = dados.foto();
        this.dataCadastro = dados.dataCadastro();
        this.documento = dados.documento();
        this.status = dados.status();
        this.sexo = dados.sexo();
        this.endereco = new Endereco(dados.endereco());
    }

    public Long getId() {
        return id;
    }

    public String getNome() {
        return nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public String getEmail() {
        return email;
    }

    public String getSenha() {
        return senha;
    }

    public String getFoto() {
        return foto;
    }

    public LocalDateTime getDataCadastro() {
        return dataCadastro;
    }

    public String getDocumento() {
        return documento;
    }

    public boolean isStatus() {
        return status;
    }

    public dtoSexo getSexo() {
        return sexo;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        this.dataNascimento = dataNascimento;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public void setFoto(String foto) {
        this.foto = foto;
    }

    public void setDataCadastro(LocalDateTime dataCadastro) {
        this.dataCadastro = dataCadastro;
    }

    public void setDocumento(String documento) {
        this.documento = documento;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

    public void setSexo(dtoSexo sexo) {
        this.sexo = sexo;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    public Usuario() {
    }

    public void atualizarInformacoes(dtoDadosAtualizacaoUsuario dados) {
        if(dados.nome()!= null){
            this.nome = dados.nome();
        }
        if(dados.telefone()!= null){
            this.telefone = dados.telefone();
        }
        if(dados.documento()!= null){
            this.documento = dados.documento();
        }

    }
}
