package com.example.university.dto;

import com.example.university.entity.Faculty;
import com.example.university.entity.School;
import com.example.university.entity.Staff;
import com.example.university.entity.Student;
import jakarta.persistence.OneToMany;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import jakarta.validation.constraints.Past;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class UniversityDTO extends MainDTO {

    @NotBlank
    private String name;

    @NotBlank
    private String location;

    @NotBlank
    private String rector;

    @NotNull
    @Past
    private LocalDate establishment;

    @NotBlank
    private String gradingSystem;

    @Null
    private List<School> schools;

    @Null
    private List<Faculty> faculty;

    @Null
    private List<Staff> staff;

    @Null
    private List<Student> student;
}
