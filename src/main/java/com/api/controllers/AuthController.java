package com.api.controllers;

import com.api.config.JwtUtil;
import com.api.domain.User;
import com.api.services.implementations.AuthService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.Optional;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private final JwtUtil jwtUtil;
    private final AuthService authService;

    public AuthController(JwtUtil jwtUtil, AuthService authService) {
        this.jwtUtil = jwtUtil;
        this.authService = authService;
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestParam String username, @RequestParam String password) {
        Optional<User> user = authService.authenticate(username, password);
        if (user.isPresent()) {
            String token = jwtUtil.generateToken(username);
            return ResponseEntity.ok(Map.of("token", "Bearer " + token));
        }
        return ResponseEntity.status(401).body("Usuário ou senha inválidos.");
    }
}
