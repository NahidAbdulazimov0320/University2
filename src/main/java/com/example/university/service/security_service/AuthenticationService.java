package com.example.university.service.security_service;

import com.example.university.dto.AuthenticationResponse;
import com.example.university.dto.RegisterRequest;
import com.example.university.entity.auth_entities.User;
import com.example.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    //What should return after user register!
    public AuthenticationResponse register(RegisterRequest request) {
        var user = User.builder()
                .firstName(request.getFirstName())
                .lastName(request.getLastName())
                .password(passwordEncoder.encode(request.getPassword()))
                .email(request.getEmail())
                .accountNonExpired(true)
                .accountNonLocked(true)
                .credentialsNonExpired(true)
                .enabled(true)
                .role(request.getRole())
                .build();

        userRepository.save(user);
        return AuthenticationResponse.builder().token(null).refreshToken(null).build();
    }

}
