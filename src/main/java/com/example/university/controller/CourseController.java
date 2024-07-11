package com.example.university.controller;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.service.MainService;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/courses")
public class CourseController extends MainController<CourseDTO, Long, Course> {

    public CourseController(MainService<CourseDTO, Long, Course> service) {
        super(service);
    }
}
