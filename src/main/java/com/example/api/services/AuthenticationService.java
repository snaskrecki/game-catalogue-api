package com.example.api.services;

import com.example.api.models.AuthenticationRequest;
import com.example.api.models.AuthenticationResponse;

public interface AuthenticationService {
    AuthenticationResponse authenticate(AuthenticationRequest request);
}
