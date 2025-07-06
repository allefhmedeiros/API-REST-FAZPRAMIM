package com.fazpramim.api.repository;

import com.fazpramim.api.entities.Prestador;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;


public interface PrestadorRepository extends JpaRepository<Prestador, Long> {

    Page<Prestador> findAllByStatusTrue(Pageable paginacao);
}
