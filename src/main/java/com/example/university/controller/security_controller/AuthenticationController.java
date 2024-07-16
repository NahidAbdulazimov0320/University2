package com.example.university.controller.security_controller;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.dto.RegisterRequest;
import com.example.university.service.security_service.AuthenticationService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

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


}
