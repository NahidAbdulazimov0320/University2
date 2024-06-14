package com.example.university.controller;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import com.example.university.mappers.StudentMapper;
import com.example.university.repository.StudentRepository;
import com.example.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController extends MainController<StudentDTO, Long, Student, StudentRepository, StudentMapper, StudentService> {


}
