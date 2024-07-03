package com.example.university.dto;

import com.example.university.entity.Enrollment;
import com.example.university.entity.Program;
import com.example.university.entity.University;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import org.springframework.lang.Nullable;

import java.util.Set;

@Getter
@AllArgsConstructor
public class StudentDTO {

    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String surname;

    @NotBlank
    private String email;

    @NotBlank
    private String address;

    @NotBlank
    private String phoneNumber;

    @NotNull
    @Positive
    private Long program_id;


}
