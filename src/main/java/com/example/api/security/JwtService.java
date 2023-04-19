package com.example.api.security;

import org.springframework.security.core.userdetails.UserDetails;

public interface JwtService {
    String extractUsername(String token);
    String generateToken(UserDetails userDetails);
    boolean validateToken(String jwt, UserDetails userDetails);
}
