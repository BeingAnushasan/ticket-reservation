package com.anushasan.ticketreservation.model.Auth;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

public class AuthResponse {
    private final String jwt;

    public AuthResponse(String jwt) {
        this.jwt = jwt;
    }

    public String getJwt() {
        return jwt;
    }
}
