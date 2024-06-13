package com.example.university.dto;

import com.example.university.enums.Semester;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Getter;

@Getter
@AllArgsConstructor
public class CourseSectionDTO{

   @NotNull
   @NotEmpty
   @NotBlank
   private Semester semester;

   @Min(value = 10, message = "Min value for course capacity can be 10.")
   @Max(value = 40, message = "Max value for course capacity cab be 40.")
   private int capacity;

}
