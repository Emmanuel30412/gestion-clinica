package com.emmanuel.clinicapp.controller;

import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.emmanuel.clinicapp.dto.AuthRequest;
import com.emmanuel.clinicapp.security.JWTUtil;

@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private final AuthenticationManager authenticatedAuthorizationManager;
    private final JWTUtil jwtUtil;

    public AuthController(AuthenticationManager authenticatedAuthorizationManager, JWTUtil jwtUtil) {
        this.authenticatedAuthorizationManager = authenticatedAuthorizationManager;
        this.jwtUtil = jwtUtil;
    }

    @PostMapping("/login")
    public String login(@RequestBody AuthRequest request) {
         try {

            authenticatedAuthorizationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getUsername(), request.getPassword())
            );

            return jwtUtil.generarToken(request.getUsername());

         }catch (org.springframework.security.core.AuthenticationException e) {
            throw new RuntimeException("Credenciales invalidas");
         }
    }
    
}
