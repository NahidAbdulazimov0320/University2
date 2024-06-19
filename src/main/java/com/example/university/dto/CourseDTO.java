package com.example.university.dto;

import com.example.university.entity.Course;
import com.example.university.entity.CourseSection;
import com.example.university.entity.Program;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CourseDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String description;

    @Null
    private boolean isActive;

    @Null
    private List<Course> preRequisite;

    @Null
    private List<Course> coreRequisite;


    @Null
    private Set<CourseSection> courseSections;


    @Null
    private Program program;

}
