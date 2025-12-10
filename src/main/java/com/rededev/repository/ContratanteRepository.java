package com.rededev.repository;

import com.rededev.domain.Contratante;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ContratanteRepository extends JpaRepository<Contratante, Long> {
    Contratante findByEmailAndSenha(String email, String senha);
}
