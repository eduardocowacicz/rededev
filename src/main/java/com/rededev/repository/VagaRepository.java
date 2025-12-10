package com.rededev.repository;

import com.rededev.domain.Vaga;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface VagaRepository extends JpaRepository<Vaga, Long> {
    List<Vaga> findByRequisitosContainingIgnoreCase(String tecnologia);
    List<Vaga> findByContratanteId(Long contratanteId);
}
