package com.example.university.dto;


import com.example.university.entity.Faculty;
import com.example.university.entity.Program;
import com.example.university.entity.Staff;
import com.example.university.entity.University;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
public class SchoolDTO {

    @Null
    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String dean;

    @NotNull
    private University university;

    @Nullable
    private LocalDate establishmentDate;

    @Null
    private List<Program> programs;

    @Null
    private List<Faculty> faculty;

    @Null
    private List<Staff> staff;
}
