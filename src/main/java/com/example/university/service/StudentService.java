package com.example.university.service;

import com.example.university.repository.StudentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
public class StudentService {

  private final StudentRepository studentRepository;

}
