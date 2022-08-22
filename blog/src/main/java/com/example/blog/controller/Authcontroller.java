package com.example.blog.controller;

import com.example.blog.dto.AuthenticateResponse;
import com.example.blog.dto.LoginRequeste;
import com.example.blog.dto.RegisterRequest;
import com.example.blog.service.AuthService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class Authcontroller {

    private final AuthService authService;

    @PostMapping("/signup")
    public ResponseEntity<Object> signup(@RequestBody RegisterRequest registerRequest){
        authService.signup(registerRequest);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @PostMapping("/login")
    public AuthenticateResponse login(@RequestBody LoginRequeste loginRequeste){
        return authService.login(loginRequeste);
    }
}
