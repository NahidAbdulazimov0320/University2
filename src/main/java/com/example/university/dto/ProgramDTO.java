package com.example.university.dto;
import com.example.university.entity.Course;
import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.List;

@Getter
@AllArgsConstructor
public class ProgramDTO extends MainDTO{

    @NotBlank
    private String name;

    private List<Course> courses;




}
