package com.example.university.controller;


import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import com.example.university.service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/coursesSections")

public class CourseSectionController extends MainController<CourseSectionDTO, Long, CourseSection> {


    public CourseSectionController(MainService<CourseSectionDTO, Long, CourseSection> service) {
        super(service);
    }
}
