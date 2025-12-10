package com.rededev.controller;

import com.rededev.domain.Competencia;
import com.rededev.service.CompetenciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/competencias")
public class CompetenciaController {

    @Autowired
    private CompetenciaService competenciaService;

    @PostMapping
    public ResponseEntity<Competencia> criar(@RequestBody Competencia competencia,
                                              @RequestParam Long programadorId) {
        Competencia salva = competenciaService.salvar(competencia, programadorId);
        if (salva == null) {
            return ResponseEntity.badRequest().build();
        }
        return ResponseEntity.ok(salva);
    }

    @GetMapping("/programador/{programadorId}")
    public List<Competencia> buscarPorProgramador(@PathVariable Long programadorId) {
        return competenciaService.buscarPorProgramador(programadorId);
    }

    @GetMapping("/buscar")
    public List<Competencia> buscarPorNome(@RequestParam String nome) {
        return competenciaService.buscarPorNome(nome);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        competenciaService.deletar(id);
        return ResponseEntity.ok().build();
    }
}
