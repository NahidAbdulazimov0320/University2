package com.example.university.service;

import com.example.university.controller.AuthenticationRequest;
import com.example.university.controller.AuthenticationResponse;
import com.example.university.controller.RegisterRequest;
import com.example.university.entity.User;
import com.example.university.enums.Role;
import com.example.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ProblemDetail;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Optional<AuthenticationResponse> register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .role(Role.USER)
                .build();
        userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return Optional.of(AuthenticationResponse.builder().token(jwtToken).build());
    }

    public Optional<AuthenticationResponse> authenticate(AuthenticationRequest request) {
      authenticationManager.authenticate(
              new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
      );
      var user = userRepository.findByEmail(request.getEmail()).orElse(null);
        var jwtToken = jwtService.generateToken(user);
        return Optional.of(AuthenticationResponse.builder().token(jwtToken).build());
    }
}
