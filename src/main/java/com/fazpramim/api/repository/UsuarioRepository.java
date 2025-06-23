package com.fazpramim.api.repository;

import com.fazpramim.api.dto.dtoDadosListagemUsuario;
import com.fazpramim.api.entities.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

}
