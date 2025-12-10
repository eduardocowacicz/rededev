package com.rededev.controller;

import com.rededev.domain.Contratante;
import com.rededev.domain.Programador;
import com.rededev.service.ContratanteService;
import com.rededev.service.ProgramadorService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final ProgramadorService programadorService;
    private final ContratanteService contratanteService;

    public AuthController(ProgramadorService programadorService, ContratanteService contratanteService) {
        this.programadorService = programadorService;
        this.contratanteService = contratanteService;
    }

    @PostMapping("/login")
    public ResponseEntity<Map<String, Object>> login(@RequestParam String email, @RequestParam String senha) {
        Programador programador = programadorService.login(email, senha);
        if (programador != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("tipo", "programador");
            response.put("usuario", programador);
            return ResponseEntity.ok(response);
        }

        Contratante contratante = contratanteService.login(email, senha);
        if (contratante != null) {
            Map<String, Object> response = new HashMap<>();
            response.put("tipo", "contratante");
            response.put("usuario", contratante);
            return ResponseEntity.ok(response);
        }

        return ResponseEntity.status(401).build();
    }
}
