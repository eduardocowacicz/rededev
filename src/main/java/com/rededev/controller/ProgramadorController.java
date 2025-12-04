package com.rededev.controller;

import com.rededev.domain.Programador;
import com.rededev.service.ProgramadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/programadores")
public class ProgramadorController {

    private final ProgramadorService service;

    public ProgramadorController(ProgramadorService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<Programador> criar(@RequestBody Programador programador) {
        Programador salvo = service.salvar(programador);
        return ResponseEntity.ok(salvo);
    }

    @GetMapping
    public ResponseEntity<List<Programador>> listarTodos() {
        return ResponseEntity.ok(service.listarTodos());
    }

    @GetMapping("/{id}")
    public ResponseEntity<Programador> buscarPorId(@PathVariable Long id) {
        return service.buscarPorId(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}
