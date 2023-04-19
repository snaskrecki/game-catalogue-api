package com.example.api.services;

import com.example.api.models.AuthenticationRequest;
import com.example.api.models.AuthenticationResponse;
import com.example.api.models.Admin;
import com.example.api.repositories.AdminRepository;
import com.example.api.security.JwtService;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class AuthenticationServiceImpl implements AuthenticationService {

    private final AdminRepository adminRepository;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    public AuthenticationServiceImpl(AdminRepository adminRepository, JwtService jwtService, AuthenticationManager authenticationManager) {
        this.adminRepository = adminRepository;
        this.jwtService = jwtService;
        this.authenticationManager = authenticationManager;
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        String username = request.getUsername();
        String password = request.getPassword();
        UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
        try {
            Authentication auth = authenticationManager.authenticate(authReq);
            Admin admin = adminRepository
                    .findByUsername(request.getUsername())
                    .orElseThrow();
            String token = jwtService.generateToken(admin);
            return new AuthenticationResponse(token);
        } catch (Exception e) {
            throw new UsernameNotFoundException("Invalid username or password");
        }
    }
}
