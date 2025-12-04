package com.rededev.service;

import com.rededev.domain.Contratante;
import com.rededev.domain.Vaga;
import com.rededev.repository.ContratanteRepository;
import com.rededev.repository.VagaRepository;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;

@Service
public class VagaService {

    private final VagaRepository vagaRepository;
    private final ContratanteRepository contratanteRepository;

    public VagaService(VagaRepository vagaRepository, ContratanteRepository contratanteRepository) {
        this.vagaRepository = vagaRepository;
        this.contratanteRepository = contratanteRepository;
    }

    public Vaga salvar(Vaga vaga, Long contratanteId) {
        Optional<Contratante> contratante = contratanteRepository.findById(contratanteId);
        if (contratante.isPresent()) {
            vaga.setContratante(contratante.get());
            return vagaRepository.save(vaga);
        }
        return null;
    }

    public List<Vaga> listarTodas() {
        return vagaRepository.findAll();
    }

    public Optional<Vaga> buscarPorId(Long id) {
        return vagaRepository.findById(id);
    }
}
