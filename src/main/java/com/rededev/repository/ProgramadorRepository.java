package com.rededev.repository;

import com.rededev.domain.Programador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
}
