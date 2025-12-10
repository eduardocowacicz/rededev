package com.rededev.service;

import com.rededev.domain.Contratante;
import com.rededev.repository.ContratanteRepository;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class ContratanteService {

    private final ContratanteRepository repository;

    public ContratanteService(ContratanteRepository repository) {
        this.repository = repository;
    }

    public Contratante salvar(Contratante contratante) {
        return repository.save(contratante);
    }

    public Optional<Contratante> buscarPorId(Long id) {
        return repository.findById(id);
    }

    public Contratante login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }
}
