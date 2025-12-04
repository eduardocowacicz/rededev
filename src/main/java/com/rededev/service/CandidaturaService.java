package com.rededev.service;

import com.rededev.domain.Candidatura;
import com.rededev.domain.Programador;
import com.rededev.domain.Vaga;
import com.rededev.domain.enums.StatusCandidatura;
import com.rededev.repository.CandidaturaRepository;
import com.rededev.repository.ProgramadorRepository;
import com.rededev.repository.VagaRepository;
import org.springframework.stereotype.Service;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

@Service
public class CandidaturaService {

    private final CandidaturaRepository candidaturaRepository;
    private final ProgramadorRepository programadorRepository;
    private final VagaRepository vagaRepository;

    public CandidaturaService(CandidaturaRepository candidaturaRepository,
                              ProgramadorRepository programadorRepository,
                              VagaRepository vagaRepository) {
        this.candidaturaRepository = candidaturaRepository;
        this.programadorRepository = programadorRepository;
        this.vagaRepository = vagaRepository;
    }

    public Candidatura candidatar(Long programadorId, Long vagaId) {
        Optional<Programador> programador = programadorRepository.findById(programadorId);
        Optional<Vaga> vaga = vagaRepository.findById(vagaId);

        if (programador.isPresent() && vaga.isPresent()) {
            Candidatura candidatura = new Candidatura();
            candidatura.setProgramador(programador.get());
            candidatura.setVaga(vaga.get());
            candidatura.setStatus(StatusCandidatura.PENDENTE);
            candidatura.setData(LocalDateTime.now());
            return candidaturaRepository.save(candidatura);
        }
        return null;
    }

    public List<Candidatura> buscarPorVaga(Long vagaId) {
        return candidaturaRepository.findByVagaId(vagaId);
    }

    public List<Candidatura> buscarPorProgramador(Long programadorId) {
        return candidaturaRepository.findByProgramadorId(programadorId);
    }

    public Candidatura atualizarStatus(Long id, StatusCandidatura status) {
        Optional<Candidatura> candidatura = candidaturaRepository.findById(id);
        if (candidatura.isPresent()) {
            candidatura.get().setStatus(status);
            return candidaturaRepository.save(candidatura.get());
        }
        return null;
    }
}
