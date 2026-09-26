package com.fazenda.saojose.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/auth")
@CrossOrigin(origins = "*")
public class AuthController {

    @PostMapping("/login")
    public ResponseEntity<Map<String, String>> login(@RequestBody Map<String, String> credentials) {
        String email = credentials.get("email");
        String password = credentials.get("password");

        Map<String, String> response = new HashMap<>();

        // Simulação básica de login para validar a integração front e back
        if ("admin@fazenda.com".equals(email) && "123456".equals(password)) {
            response.put("message", "Login realizado com sucesso!");
            response.put("token", "fake-jwt-token-sao-jose");
            return ResponseEntity.ok(response);
        }

        response.put("error", "E-mail ou senha inválidos!");
        return ResponseEntity.status(401).body(response);
    }
}