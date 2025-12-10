package com.rededev.service;

import com.rededev.domain.Experiencia;
import com.rededev.domain.Programador;
import com.rededev.repository.ExperienciaRepository;
import com.rededev.repository.ProgramadorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ExperienciaService {

    @Autowired
    private ExperienciaRepository experienciaRepository;

    @Autowired
    private ProgramadorRepository programadorRepository;

    public Experiencia salvar(Experiencia experiencia, Long programadorId) {
        Programador programador = programadorRepository.findById(programadorId).orElse(null);
        if (programador == null) {
            return null;
        }
        experiencia.setProgramador(programador);
        return experienciaRepository.save(experiencia);
    }

    public List<Experiencia> buscarPorProgramador(Long programadorId) {
        return experienciaRepository.findByProgramadorId(programadorId);
    }

    public void deletar(Long id) {
        experienciaRepository.deleteById(id);
    }
}
