package com.example.university.controller;

import com.example.university.service.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RequiredArgsConstructor
@RestController
@RequestMapping("/students")
public class StudentController{

  private final StudentService studentService;











}
