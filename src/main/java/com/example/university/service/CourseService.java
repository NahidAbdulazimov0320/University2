package com.example.university.service;


import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


//openapi, springdoc, swagger

@Service
public class CourseService extends MainService<CourseDTO, Long, Course> {
    public CourseService(JpaRepository<Course, Long> repository, MainMapper<CourseDTO, Course> mapper) {
        super(repository, mapper);
    }
}
