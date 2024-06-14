package com.example.university.controller;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.mappers.CourseMapper;
import com.example.university.repository.CourseRepository;
import com.example.university.service.CourseService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courses")
public class CourseController extends MainController<CourseDTO, Long, Course, CourseRepository, CourseMapper, CourseService> {


}
