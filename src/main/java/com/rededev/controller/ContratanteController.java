package com.rededev.controller;

import com.rededev.domain.Contratante;
import com.rededev.service.ContratanteService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/contratantes")
public class ContratanteController {

    private final ContratanteService service;

    public ContratanteController(ContratanteService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Contratante> criar(@RequestBody Contratante contratante) {
        Contratante salvo = service.salvar(contratante);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Contratante> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping("/login")
    public ResponseEntity<Contratante> login(@RequestParam String email, @RequestParam String senha) {
        Contratante contratante = service.login(email, senha);
        if (contratante != null) {
            return ResponseEntity.ok(contratante);
        }
        return ResponseEntity.status(401).build();
    }
}
