package com.example.springSecurity.Controller;

public record AuthResponseDTO(String name, String email,String password) {
    public AuthResponseDTO(Object jwtToken) {
    }
}
