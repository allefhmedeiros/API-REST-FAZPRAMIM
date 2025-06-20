package com.fazpramim.api.entities;

import com.fazpramim.api.dto.dtoSexo;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

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
    private String dataNascimento;
    private String email;
    private String senha;
    private String foto;
    private String dataCadastro;
    private String documento;
    boolean status;
    @Enumerated(EnumType.STRING)
    private dtoSexo sexo;
    private Endereco endereco;
}
