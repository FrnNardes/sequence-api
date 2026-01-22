package com.sequence.user.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import javax.crypto.SecretKey;
import java.nio.charset.StandardCharsets;
import java.util.Date;

@Service
public class JwtSecurity {
    @Value("${jwt.secret}")
    private String secretKey;

    @Value("${jwt.expiration}")
    private long expirationTime;

    public String generateToken(String email){
        SecretKey key = Keys.hmacShaKeyFor(secretKey.getBytes(StandardCharsets.UTF_8));

        return Jwts.builder()
                .subject(email) // Who is this for?
                .issuedAt(new Date()) // When was it made?
                .expiration(new Date(System.currentTimeMillis() + expirationTime)) // When does it die?
                .signWith(key) // Seal it with our secret
                .compact(); // Turn it into a string
    }
}
