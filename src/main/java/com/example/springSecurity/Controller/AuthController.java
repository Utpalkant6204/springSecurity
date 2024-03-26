package com.example.springSecurity.Controller;

import com.example.springSecurity.Service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }


    @PostMapping("/login")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authResponseDto){
        var jwtToken = authService.login(authResponseDto.email(), authResponseDto.password());
        return null;
    }

    @PostMapping("/sign-up")
    public ResponseEntity<AuthResponseDTO> login(@RequestBody AuthRequestDTO authResponseDto){
        return null;
    }

}
