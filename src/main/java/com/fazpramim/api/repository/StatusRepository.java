package com.fazpramim.api.repository;

import com.fazpramim.api.entities.Status;
import org.springframework.data.jpa.repository.JpaRepository;

public interface StatusRepository extends JpaRepository<Status, Long> {
}
