package com.example.university.service;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class StudentService extends MainService<StudentDTO, Long, Student> {

    public StudentService(JpaRepository<Student, Long> repository, MainMapper<StudentDTO, Student> mapper) {
        super(repository, mapper);
    }
}
