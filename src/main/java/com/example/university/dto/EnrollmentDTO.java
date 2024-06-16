package com.example.university.dto;

import com.example.university.enums.Semester;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
// TODO
public class EnrollmentDTO {

    @Positive
     private Long studentId;

    @Positive
     private Long courseSectionId;

    @NotNull
     private Semester semester;



}
