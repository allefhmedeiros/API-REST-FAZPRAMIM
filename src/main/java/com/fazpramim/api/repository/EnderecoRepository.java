package com.fazpramim.api.repository;

import com.fazpramim.api.entities.Endereco;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EnderecoRepository  extends JpaRepository<Endereco, Long> {
    Page<Endereco> findAllByStatusTrue(Pageable paginacao);
}
