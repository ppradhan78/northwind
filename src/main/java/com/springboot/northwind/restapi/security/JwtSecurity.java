package com.springboot.northwind.restapi.security;


import io.jsonwebtoken.*;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component
public class JwtSecurity {

    private static final String SECRET_KEY = "supersecretkeyforsigningjwttokens1234567890";
    private static final long EXPIRATION_TIME = 1000 * 60 * 60; // 1 hour

private Key getSigningKey() {
    byte[] keyBytes = Decoders.BASE64.decode(SECRET_KEY);
    return Keys.hmacShaKeyFor(keyBytes);
}
public String generateToken(String username, String email, String phoneNumber, String role) {
    return Jwts.builder()
            .setSubject(username)
            .claim("Email", email)
            .claim("PhoneNumber", phoneNumber)
            .claim("role", role)
            .setIssuedAt(new Date())
            .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME)) // 1 hour
            .signWith(getSigningKey(), SignatureAlgorithm.HS256)

            .compact();
}

public String extractUsername(String token) {
    return extractAllClaims(token).get("UserName", String.class);
}
public String extractEmail(String token) {
    return extractAllClaims(token).get("Email", String.class);
}

    public String extractPhoneNumber(String token) {
        return extractAllClaims(token).get("PhoneNumber", String.class);
    }

    public String extractRole(String token) {
        return extractAllClaims(token).get("Role", String.class);
    }
    public Claims extractAllClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }

    public boolean validateToken(String token) {
        try {
              parseClaims(token);
            return true;
        } catch (JwtException e) {
            return false;
        }
    }

    private Claims parseClaims(String token) {
        return Jwts.parserBuilder()
                .setSigningKey(getSigningKey())
                .build()
                .parseClaimsJws(token)
                .getBody();
    }
}
