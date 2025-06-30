package com.fazpramim.api.repository;

import com.fazpramim.api.dto.dtoDadosListagemUsuario;
import com.fazpramim.api.entities.Usuario;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    Page<Usuario> findAllByStatusTrue(Pageable paginarDevolucao);
}
