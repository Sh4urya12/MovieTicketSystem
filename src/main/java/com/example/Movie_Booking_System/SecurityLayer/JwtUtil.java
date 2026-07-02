package com.example.Movie_Booking_System.SecurityLayer;

import io.jsonwebtoken.*;

import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;

@Component

public class JwtUtil
{
    private final String SECRET_KEY = "mysecretkeymysecretkeymysecretkey12345";
    private final long EXPIRATION_TIME = 1000 * 60 * 60;

    private Key getSignKey()
    {
        return Keys.hmacShaKeyFor(SECRET_KEY.getBytes());
    }

    public String generateToken(String email)
    {
        return Jwts.builder().setSubject(email).setIssuedAt(new Date())
                .setExpiration(new Date(System.currentTimeMillis() + EXPIRATION_TIME))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }

    public String extractEmail(String token)
    {
        return Jwts.parserBuilder()
                .setSigningKey(getSignKey())
                .build()
                .parseClaimsJws(token)
                .getBody()
                .getSubject();
    }

    public boolean validateToken(String token)
    {
        try
        {
            Jwts.parserBuilder()
                    .setSigningKey(getSignKey())
                    .build()
                    .parseClaimsJws(token);
            return true;
        }
        catch(Exception e)
        {
            return false;
        }
    }
}

