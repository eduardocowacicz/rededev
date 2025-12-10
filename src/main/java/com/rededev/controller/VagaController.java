package com.rededev.controller;

import com.rededev.domain.Candidatura;
import com.rededev.domain.Vaga;
import com.rededev.service.CandidaturaService;
import com.rededev.service.VagaService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/vagas")
public class VagaController {

    private final VagaService vagaService;
    private final CandidaturaService candidaturaService;

    public VagaController(VagaService vagaService, CandidaturaService candidaturaService) {
        this.vagaService = vagaService;
        this.candidaturaService = candidaturaService;
    }

    @PostMapping
    public ResponseEntity<Vaga> criar(@RequestBody Vaga vaga, @RequestParam Long contratanteId) {
        Vaga salva = vagaService.salvar(vaga, contratanteId);
        if (salva != null) {
            return ResponseEntity.ok(salva);
        }
        return ResponseEntity.badRequest().build();
    }

    @GetMapping
    public ResponseEntity<List<Vaga>> listarTodas() {
        return ResponseEntity.ok(vagaService.listarTodas());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Vaga> buscarPorId(@PathVariable Long id) {
        return vagaService.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/{id}/candidatos")
    public ResponseEntity<List<Candidatura>> listarCandidatos(@PathVariable Long id) {
        return ResponseEntity.ok(candidaturaService.buscarPorVaga(id));
    }

    @GetMapping("/buscar")
    public ResponseEntity<List<Vaga>> buscarPorTecnologia(@RequestParam String tecnologia) {
        return ResponseEntity.ok(vagaService.buscarPorTecnologia(tecnologia));
    }
}
