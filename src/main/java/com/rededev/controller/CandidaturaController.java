package com.rededev.controller;

import com.rededev.domain.Candidatura;
import com.rededev.domain.enums.StatusCandidatura;
import com.rededev.service.CandidaturaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/candidaturas")
public class CandidaturaController {

    private final CandidaturaService service;

    public CandidaturaController(CandidaturaService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Candidatura> candidatar(@RequestParam Long programadorId, @RequestParam Long vagaId) {
        Candidatura candidatura = service.candidatar(programadorId, vagaId);
        if (candidatura != null) {
            return ResponseEntity.ok(candidatura);
        }
        return ResponseEntity.badRequest().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<Candidatura> atualizarStatus(@PathVariable Long id, @RequestParam StatusCandidatura status) {
        Candidatura candidatura = service.atualizarStatus(id, status);
        if (candidatura != null) {
            return ResponseEntity.ok(candidatura);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping("/programador/{programadorId}")
    public ResponseEntity<List<Candidatura>> minhasCandidaturas(@PathVariable Long programadorId) {
        return ResponseEntity.ok(service.buscarPorProgramador(programadorId));
    }
}
