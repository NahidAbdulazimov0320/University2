package com.example.university.dto;

import com.example.university.entity.Course;
import com.example.university.entity.School;
import com.example.university.entity.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProgramDTO {

    private Long id;

    @NotBlank
    private String name;

    @Null
    private List<Course> courses;

    @Null
    private List<Student> students;

    @Null
    private School school;


}
