package com.example.university.service;


import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.mappers.CourseMapper;
import com.example.university.repository.CourseRepository;
import org.springframework.stereotype.Service;


@Service
public class CourseService extends MainService<CourseRepository, CourseDTO, Long, Course, CourseMapper> {


    public CourseService(CourseRepository repository, CourseMapper mapper) {
        super(repository, mapper);
    }
}
