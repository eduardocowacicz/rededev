package com.rededev.repository;

import com.rededev.domain.Experiencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ExperienciaRepository extends JpaRepository<Experiencia, Long> {
    List<Experiencia> findByProgramadorId(Long programadorId);
}
