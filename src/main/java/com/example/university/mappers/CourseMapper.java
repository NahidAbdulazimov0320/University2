package com.example.university.mappers;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import org.mapstruct.Mapper;

@Mapper
public interface CourseMapper{

    CourseDTO courseToCourseDTO(Course course);
    Course courseDTOToCourse(CourseDTO courseDTO);

}
