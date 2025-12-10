package com.rededev.service;

import com.rededev.domain.Competencia;
import com.rededev.domain.Programador;
import com.rededev.repository.CompetenciaRepository;
import com.rededev.repository.ProgramadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompetenciaService {

    @Autowired
    private CompetenciaRepository competenciaRepository;

    @Autowired
    private ProgramadorRepository programadorRepository;

    public Competencia salvar(Competencia competencia, Long programadorId) {
        Programador programador = programadorRepository.findById(programadorId).orElse(null);
        if (programador == null) {
            return null;
        }
        competencia.setProgramador(programador);
        return competenciaRepository.save(competencia);
    }

    public List<Competencia> buscarPorProgramador(Long programadorId) {
        return competenciaRepository.findByProgramadorId(programadorId);
    }

    public List<Competencia> buscarPorNome(String nome) {
        return competenciaRepository.findByNomeContainingIgnoreCase(nome);
    }

    public void deletar(Long id) {
        competenciaRepository.deleteById(id);
    }
}
