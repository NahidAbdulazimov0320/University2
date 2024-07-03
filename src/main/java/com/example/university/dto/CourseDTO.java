package com.example.university.dto;

import com.example.university.entity.Course;
import com.example.university.entity.CourseSection;
import com.example.university.entity.Program;
import jakarta.persistence.Lob;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import java.util.List;
import java.util.Set;

@Getter
@AllArgsConstructor
public class CourseDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    @Length(max = 1000)
    private String description;

    private boolean isActive;

    @Positive
    @NotNull
    private Long program_id;

}
