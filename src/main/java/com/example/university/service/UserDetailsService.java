package com.example.university.service;

import com.example.university.exceptions.NoDataFound;
import com.example.university.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestMapping;

@Service
@RequiredArgsConstructor
public class UserDetailsService {

    private final UserRepository userRepository;

    public UserDetails loadUserByUsername(String username){
        return userRepository.findByEmail(username)
                .orElseThrow();
    }
}
