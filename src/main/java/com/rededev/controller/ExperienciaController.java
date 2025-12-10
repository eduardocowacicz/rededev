package com.rededev.controller;

import com.rededev.domain.Experiencia;
import com.rededev.service.ExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/experiencias")
public class ExperienciaController {

    @Autowired
    private ExperienciaService experienciaService;

    @PostMapping
    public ResponseEntity<Experiencia> criar(@RequestBody Experiencia experiencia,
                                              @RequestParam Long programadorId) {
        Experiencia salva = experienciaService.salvar(experiencia, programadorId);
        if (salva == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(salva);
    }

    @GetMapping("/programador/{programadorId}")
    public List<Experiencia> buscarPorProgramador(@PathVariable Long programadorId) {
        return experienciaService.buscarPorProgramador(programadorId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        experienciaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
