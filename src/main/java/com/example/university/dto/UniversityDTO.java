package com.example.university.dto;

import com.example.university.entity.Faculty;
import com.example.university.entity.School;
import com.example.university.entity.Staff;
import com.example.university.entity.Student;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UniversityDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String rector;

    @NotBlank
    private String gradingSystem;

    @NotNull
    @Past
    private LocalDate establishment;


    @Nullable
    private List<School> schools;

    @Nullable
    private List<Faculty> faculty;

    @Nullable
    private List<Staff> staff;

    @Null
    private List<Student> student;

}
