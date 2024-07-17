package org.example.schoolmanagementsystem.controller;

import lombok.AllArgsConstructor;
import org.example.schoolmanagementsystem.dto.JwtAuthResponse;
import org.example.schoolmanagementsystem.dto.LoginDto;
import org.example.schoolmanagementsystem.service.AuthService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@AllArgsConstructor
@RestController
@RequestMapping("/api/auth")
public class AuthController {

    private AuthService authService;


    @PostMapping("/login")
    public ResponseEntity<JwtAuthResponse> login(@RequestBody LoginDto loginDto) {
        String token = authService.login(loginDto);
        JwtAuthResponse jwtAuthResponse = new JwtAuthResponse();
        jwtAuthResponse.setAccessToken(token);
        return new ResponseEntity<>(jwtAuthResponse, HttpStatus.OK);
    }

    @GetMapping("/hello")
    public String hello(){
        return "Hello";
    }
}
