package com.example.university.service;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import com.example.university.mappers.StudentMapper;
import com.example.university.repository.StudentRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentService extends MainService<StudentRepository, StudentMapper, StudentDTO, Long, Student> {

    public StudentService(StudentRepository repository, StudentMapper mapper) {
        super(repository, mapper);
    }
}
