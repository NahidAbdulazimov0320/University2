package com.example.university.config;

import com.example.university.dto.AuthenticationRequest;
import com.example.university.dto.AuthenticationResponse;
import com.example.university.entity.auth_entities.Token;
import com.example.university.entity.auth_entities.User;
import com.example.university.enums.TokenType;
import com.example.university.repository.TokenRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import jakarta.servlet.FilterChain;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.AllArgsConstructor;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

import java.io.IOException;

import static com.example.university.service.security_service.JwtService.generateRefreshToken;
import static com.example.university.service.security_service.JwtService.generateToken;

@Configuration
@AllArgsConstructor
public class CustomAuthenticationFilter extends UsernamePasswordAuthenticationFilter {

    private final ObjectMapper objectMapper;
    private final TokenRepository tokenRepository;
    private AuthenticationProvider authenticationProvider;


    @Override
    public Authentication attemptAuthentication(HttpServletRequest request, HttpServletResponse response) throws AuthenticationException {
        try {
            AuthenticationRequest authRequest = objectMapper.readValue(request.getReader(), AuthenticationRequest.class);
            UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(authRequest.getEmail(), authRequest.getPassword());
            return authenticationProvider.authenticate(authToken);
        } catch (IOException | AuthenticationException ef) {
            logger.info("Exception thrown inside attemptAuthentication!");
            throw new RuntimeException("Unable to authenticate user");
        }
    }

    @Override
    public void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain, Authentication authResult) throws IOException {
        User user = (User) authResult.getPrincipal();
        String accessToken = generateToken(user);
        String refreshToken = generateRefreshToken(user);
        revokeTokenFromDatabase(user);
        saveTokenToDatabase(user, accessToken);
        response.getWriter().write(new ObjectMapper().writeValueAsString(AuthenticationResponse.builder().token(accessToken).refreshToken(refreshToken)));
        response.getWriter().flush();
    }

    @Override
    public void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response, AuthenticationException failed) throws IOException, ServletException {
        response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
        super.unsuccessfulAuthentication(request, response, failed);
    }

    private void saveTokenToDatabase(User user, String accessToken) {
        var token = Token.builder()
                .user(user)
                .token(accessToken)
                .tokenType(TokenType.BEARER)
                .expired(false)
                .revoked(false)
                .build();
        tokenRepository.save(token);
    }

    private void revokeTokenFromDatabase(User user) {
        var validTokens = tokenRepository.findAllValidTokensByUser(Long.valueOf(user.getId()));
        if (!validTokens.isEmpty()) {
            validTokens.forEach(token -> {
                token.setExpired(true);
                token.setRevoked(true);
            });
        }
        tokenRepository.saveAll(validTokens);
    }


}
