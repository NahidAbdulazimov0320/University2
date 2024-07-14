package com.example.university.service.security_service;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.dto.RegisterRequest;
import com.example.university.entity.auth_entities.Token;
import com.example.university.entity.auth_entities.User;
import com.example.university.enums.TokenType;
import com.example.university.repository.TokenRepository;
import com.example.university.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

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
        var jwtToken = jwtService.generateToken(user);
        var refreshToken = jwtService.generateRefreshToken(user);
        revokeAllUserTokens(user);
        createAndSaveToken(user, jwtToken);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(refreshToken).build();
    }

    public AuthenticationResponse authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElse(null);
        var jwtToken = jwtService.generateToken(user);
        assert user != null;
        revokeAllUserTokens(user);  //Making previous tokens expired, since another token is requested!
        createAndSaveToken(user, jwtToken);
        var refreshToken = jwtService.generateRefreshToken(user);
        return AuthenticationResponse.builder().token(jwtToken).refreshToken(refreshToken).build();
    }

    private void revokeAllUserTokens(User user) {
        var validTokens = tokenRepository.findAllValidTokensByUser(Long.valueOf(user.getId()));
        if (validTokens.isEmpty()) {
            return;
        }
        validTokens.forEach(token -> {
            token.setExpired(true);
            token.setRevoked(true);
        });
        tokenRepository.saveAll(validTokens);
    }

    private void createAndSaveToken(User savedUser, String jwtToken) {
        var token = Token.builder()
                .user(savedUser)
                .token(jwtToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    public void refreshToken(HttpServletRequest request, HttpServletResponse response) throws IOException {
        final String authHeader = request.getHeader("Authorization");
        if (authHeader == null || !authHeader.startsWith("Bearer ")) {
            return;
        }
        String refreshToken = authHeader.substring(7);
        String userEmail = jwtService.extractUsername(refreshToken);
        if (userEmail != null) {
            var userDetails = userRepository.findByEmail(userEmail).orElseThrow();
            if (jwtService.isTokenValid(refreshToken, userDetails)) {
                var accessToken = jwtService.generateToken(userDetails);
                revokeAllUserTokens(userDetails);
                createAndSaveToken(userDetails, accessToken);
                var authResponse = AuthenticationResponse.builder().token(accessToken).refreshToken(refreshToken).build();

                new ObjectMapper().writeValue(response.getOutputStream(), authResponse);
            }


        }

    }
}
