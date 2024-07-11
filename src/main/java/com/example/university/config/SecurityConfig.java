package com.example.university.config;

import com.example.university.enums.Role;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.CsrfConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@EnableWebSecurity
@RequiredArgsConstructor
public class SecurityConfig {

    private final JwtAuthenticationFilter jwtAuthenticationFilter;
    private final AuthenticationProvider authenticationProvider;

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http) throws Exception {
        http
                .csrf(CsrfConfigurer::disable)
                .authorizeHttpRequests(authorize -> authorize.requestMatchers("/api/v1/auth/**").permitAll()
                        .requestMatchers("/universities/**").hasAuthority(Role.ADMIN.name())
                        .requestMatchers("/schools/**", "/students/**", "/programs/**", "/courses/**", "/enrollments/**", "/faculties/**").hasAnyAuthority(Role.ADMIN.name(), Role.MANAGER.name())
                        .requestMatchers("/coursesSections/**").hasAnyAuthority(Role.MANAGER.name())
                        // .requestMatchers("/s).hasAnyAuthority(Role.MANAGER.name())
                        .anyRequest().authenticated()).sessionManagement(httpSecuritySessionManagementConfigurer -> httpSecuritySessionManagementConfigurer.sessionCreationPolicy(SessionCreationPolicy.STATELESS))
                .authenticationProvider(authenticationProvider)
                .addFilterBefore(jwtAuthenticationFilter, UsernamePasswordAuthenticationFilter.class);
        return http.build();


    }

}