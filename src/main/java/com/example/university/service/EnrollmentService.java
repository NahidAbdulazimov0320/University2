package com.example.university.service;

import com.example.university.repository.EnrollmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class EnrollmentService {

    private final EnrollmentRepository enrollmentRepository;


}
