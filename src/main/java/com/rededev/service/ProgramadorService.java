package com.rededev.service;

import com.rededev.domain.Programador;
import com.rededev.repository.ProgramadorRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class ProgramadorService {

    private final ProgramadorRepository repository;

    public ProgramadorService(ProgramadorRepository repository) {
        this.repository = repository;
    }

    public Programador salvar(Programador programador) {
        return repository.save(programador);
    }

    public List<Programador> listarTodos() {
        return repository.findAll();
    }

    public Optional<Programador> buscarPorId(Long id) {
        return repository.findById(id);
    }
}
