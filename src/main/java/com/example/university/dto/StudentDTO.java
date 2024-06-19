package com.example.university.dto;

import com.example.university.entity.Enrollment;
import com.example.university.entity.Program;
import com.example.university.entity.University;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Null;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;

@Getter
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank
    @NotEmpty
    @NotNull
    private String name;

    @NotBlank
    @NotEmpty
    @NotNull
    private String surname;

    @Nullable
    private String email;

    @Nullable
    private String address;

    @Nullable
    private String phoneNumber;

    @Null
    private Set<Enrollment> enrollments;

    @Null
    private Program program;

    @Null
    private University university;
}
