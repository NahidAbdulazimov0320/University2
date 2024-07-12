package com.example.university.service;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.dto.RegisterRequest;
import com.example.university.entity.Token;
import com.example.university.entity.User;
import com.example.university.enums.TokenType;
import com.example.university.repository.TokenRepository;
import com.example.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class AuthenticationService {

    private final UserRepository userRepository;
    private final TokenRepository tokenRepository;
    private final JwtService jwtService;
    private final PasswordEncoder passwordEncoder;
    private final AuthenticationManager authenticationManager;

    public Optional<AuthenticationResponse> register(RegisterRequest request) {
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

        var savedUser = userRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        createAndSaveToken(savedUser, jwtToken);
        return Optional.of(AuthenticationResponse.builder().token(jwtToken).build());
    }

    public Optional<AuthenticationResponse> authenticate(AuthenticationRequest request) {
        authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(request.getEmail(), request.getPassword())
        );
        var user = userRepository.findByEmail(request.getEmail()).orElse(null);
        var jwtToken = jwtService.generateToken(user);
        assert user != null;
        revokeAllUserTokens(user);  //Making them expired, since another token is requested!
        createAndSaveToken(user, jwtToken);
        return Optional.of(AuthenticationResponse.builder().token(jwtToken).build());
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

}
