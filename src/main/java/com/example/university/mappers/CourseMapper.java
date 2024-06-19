package com.example.university.mappers;

import com.example.university.dto.CourseDTO;
import com.example.university.entity.Course;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface CourseMapper extends MainMapper<CourseDTO, Course>{


}
