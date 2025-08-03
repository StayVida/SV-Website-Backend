package com.stayvida.backend.dto;

public class LoginResponse {
    private boolean success;
    private String token;
    private String name;
    private String email;
    private String message;

    public LoginResponse() {
    }

    public LoginResponse(boolean success, String token, String name, String email, String message) {
        this.success = success;
        this.token = token;
        this.name = name;
        this.email = email;
        this.message = message;
    }

    // Getters
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

    public String getMessage() {
        return message;
    }
}
