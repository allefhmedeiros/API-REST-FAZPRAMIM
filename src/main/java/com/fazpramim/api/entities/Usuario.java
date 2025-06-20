package com.fazpramim.api.entities;

import com.fazpramim.api.dto.dtoDadosCadastroMedico;
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
    private dtoSexo sexo;
    @Embedded
    private Endereco endereco;

    public Usuario(dtoDadosCadastroMedico dados) {
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
}
