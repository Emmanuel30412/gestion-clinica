package com.emmanuel.clinicapp.security;

import java.security.Key;
import java.util.Date;

import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.JwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.security.Keys;

@Component
public class JWTUtil {
    
    private final String SECRET = "CRISTOTE-AMA-dio-SU-VIDA-POR-TI";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    private Key getKey(){
       return Keys.hmacShaKeyFor(SECRET.getBytes());
    }

    //Crea un token con el nombre de usuario y una duracion de 1 hora
    public String generarToken(String username) {
        return Jwts.builder()
                .setSubject(username)
                .setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis()))
                .signWith(getKey(),  SignatureAlgorithm.ES256)
                .compact();

    }

    //Extraer el username que se guardo en el token
    public String extraerUserName(String token) {
        return getClaims(token).getSubject();
    }

    //Verifica que el token no esta vencido ni corrupto
    public boolean validarToken(String token) {
        try {
            getClaims(token);
            return true;

        }catch(JwtException e) {
            return false;
        }
    }

    //Genera la clave segura para firmar/verificar.
    private Claims getClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
