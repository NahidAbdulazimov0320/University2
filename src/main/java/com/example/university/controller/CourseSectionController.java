package com.example.university.controller;


import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import com.example.university.mappers.CourseSectionMapper;
import com.example.university.repository.CourseSectionRepository;
import com.example.university.service.CourseSectionService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/courseSections")

public class CourseSectionController extends MainController<CourseSectionDTO, Long, CourseSection, CourseSectionRepository, CourseSectionMapper, CourseSectionService> {


}
