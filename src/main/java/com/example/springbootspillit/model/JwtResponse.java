package com.example.springbootspillit.model;

public class JwtResponse {

    private String jwt;

    public JwtResponse(String jwt) {
        this.jwt = jwt;
    }

    public JwtResponse(User user) {

    }

    public String getToken() {
        return this.jwt;
    }
}
