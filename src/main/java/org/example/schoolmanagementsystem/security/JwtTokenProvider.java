package org.example.schoolmanagementsystem.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.crypto.SecretKey;
import java.security.Key;
import java.util.Date;

@Component
public class JwtTokenProvider {

    @Value("${app.jwtSecret}")
    private String jwtSecret;

    @Value("${app.jwtExpirationInMs}")
    private int jwtExpirationInMs;

    // methods


    // Generate JWT Token
    public String generateToken(Authentication authentication) {

            String token = Jwts.builder()
                    .setSubject((authentication.getName()))
                    .setIssuedAt(new Date())
                    .setExpiration(new Date((new Date()).getTime() + jwtExpirationInMs))
                    .signWith(keys())
                    .compact();
            return token;
    }


    // Get Key from jwtSecret
    public Key keys(){
        return Keys.hmacShaKeyFor(Decoders.BASE64.decode(jwtSecret));
    }


    // Get Username from JWT Token
    public String getUsernameFromJWT(String token) {
        return Jwts.parser().
                verifyWith((SecretKey) keys())
                .build()
                .parseSignedClaims(token)
                .getPayload()
                .getSubject();
    }

    // Validate JWT Token
    public boolean validateToken(String token){
        try {
            Jwts.parser()
                    .verifyWith((SecretKey) keys())
                    .build()
                    .parse(token);
            return true;
        } catch (Exception e){
            System.out.println("Invalid JWT Token");
        }
        return false;
    }
}
