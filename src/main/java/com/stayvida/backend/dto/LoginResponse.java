package com.stayvida.backend.dto;

public class LoginResponse {
    private boolean success;
    private String token;
    private String name;
    private String email;

    public LoginResponse(boolean success, String token, String name, String email) {
        this.success = success;
        this.token = token;
        this.name = name;
        this.email = email;
    }

    // Getters & Setters
    public boolean isSuccess() {
        return success;
    }

    public String getToken() {
        return token;
    }

    public String getName() {
        return name;
    }
    public String getEmail() {
        return email;
    }
}
