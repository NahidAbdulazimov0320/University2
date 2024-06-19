package com.example.university.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Null;
import lombok.Getter;
import lombok.Setter;
import org.springframework.lang.Nullable;

import java.time.LocalDate;

@Getter
@Setter
public class SchoolDTO {


    private Long id;

    @NotBlank
    private String name;

    @NotBlank
    private String dean;

    @Nullable
    private LocalDate establishmentDate;

    private Long university_id;

}
