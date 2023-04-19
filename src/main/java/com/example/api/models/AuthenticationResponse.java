package com.example.api.models;

public class AuthenticationResponse {

    private String jwt;

    public AuthenticationResponse() {

    }

    public AuthenticationResponse(String token) {
        this.jwt = token;
    }

    public String getJwt() {
        return jwt;
    }

    public void setJwt(String jwt) {
        this.jwt = jwt;
    }
}
