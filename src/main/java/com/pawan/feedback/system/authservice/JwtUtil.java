package com.pawan.feedback.system.authservice;

import java.util.Date;
import java.util.List;

import javax.crypto.SecretKey;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.security.Keys;

@Component
public class JwtUtil {

    // SECRET KEY (minimum 256 bits)
    private static final String SECRET =
            "onlineFeedbackSystemSecretKeyonlineFeedbackSystemSecretKey";

    // GENERATE KEY
    private final SecretKey key =
            Keys.hmacShaKeyFor(SECRET.getBytes());
    // TOKEN VALIDITY -> 24 HOURS
    private static final long JWT_EXPIRATION =
            1000 * 60 * 60 * 24;

    // GENERATE TOKEN
    public String generateToken(
    	    String email,
    	    List<String> roles
    	) {

        return Jwts.builder()

                .subject(email)

                .claim("role", roles)

                .issuedAt(new Date())

                .expiration(
                        new Date(
                                System.currentTimeMillis()
                                        + JWT_EXPIRATION
                        )
                )

                .signWith(key, Jwts.SIG.HS256)

                .compact();
    }

    // EXTRACT EMAIL
    public String extractEmail(String token) {

        return extractAllClaims(token)
                .getSubject();
    }

    // EXTRACT ROLE
    public List<String> extractRoles(String token) {

        return extractAllClaims(token)
                .get("roles", List.class);
    }
    // EXTRACT EXPIRATION
    public Date extractExpiration(String token) {

        return extractAllClaims(token)
                .getExpiration();
    }

    // EXTRACT ALL CLAIMS
    private Claims extractAllClaims(String token) {

        return Jwts.parser()

                .verifyWith((javax.crypto.SecretKey) key)

                .build()

                .parseSignedClaims(token)

                .getPayload();
    }

    // CHECK TOKEN EXPIRATION
    private boolean isTokenExpired(String token) {

        return extractExpiration(token)
                .before(new Date());
    }

    // VALIDATE TOKEN
    public boolean validateToken(
            String token,
            UserDetails userDetails
    ) {

        final String email =
                extractEmail(token);

        return email.equals(userDetails.getUsername())
                && !isTokenExpired(token);
    }
}