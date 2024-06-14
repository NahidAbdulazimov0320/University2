package com.example.university.service;


import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import com.example.university.mappers.CourseMapper;
import com.example.university.repository.CourseRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;



@Service
public class CourseService extends MainService<CourseRepository, CourseMapper, CourseDTO, Long , Course> {


    public CourseService(CourseRepository repository, CourseMapper mapper) {
        super(repository, mapper);
    }
}
