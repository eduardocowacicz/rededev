package com.rededev.repository;

import com.rededev.domain.Competencia;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompetenciaRepository extends JpaRepository<Competencia, Long> {
    List<Competencia> findByProgramadorId(Long programadorId);
    List<Competencia> findByNomeContainingIgnoreCase(String nome);
}
