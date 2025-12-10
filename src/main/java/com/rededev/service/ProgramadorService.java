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

    public Programador login(String email, String senha) {
        return repository.findByEmailAndSenha(email, senha);
    }

    public List<Programador> buscarPorCompetencia(String competencia) {
        return repository.findByCompetenciasContainingIgnoreCase(competencia);
    }

    public List<Programador> buscar(String termo) {
        return repository.findByNomeContainingIgnoreCaseOrCompetenciasContainingIgnoreCase(termo, termo);
    }
}
