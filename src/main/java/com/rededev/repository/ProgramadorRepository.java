package com.rededev.repository;

import com.rededev.domain.Programador;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProgramadorRepository extends JpaRepository<Programador, Long> {
    Programador findByEmailAndSenha(String email, String senha);
    List<Programador> findByCompetenciasContainingIgnoreCase(String competencia);
    List<Programador> findByNomeContainingIgnoreCase(String nome);
    List<Programador> findByNomeContainingIgnoreCaseOrCompetenciasContainingIgnoreCase(String nome, String competencia);
}
