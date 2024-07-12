package com.example.university.controller;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.dto.RegisterRequest;
import com.example.university.service.AuthenticationService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {

    private final AuthenticationService authenticationService;

    @PostMapping("/sign-up")
    @ResponseStatus(HttpStatus.CREATED)
    public AuthenticationResponse register(
            @RequestBody RegisterRequest request) {
        return authenticationService.register(request);
    }


    @PostMapping("/sign-in")
    @ResponseStatus(HttpStatus.OK)
    public AuthenticationResponse authenticateRequest(
            @RequestBody AuthenticationRequest request) {
        return authenticationService.authenticate(request);

    }

    @PostMapping("/refresh-token")
    @ResponseStatus(HttpStatus.OK)
    public void refreshToken(
            HttpServletRequest request, HttpServletResponse response
    ) throws IOException {
        authenticationService.refreshToken(request, response);
    }


}
