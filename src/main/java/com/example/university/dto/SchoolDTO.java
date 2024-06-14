package com.example.university.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SchoolDTO extends MainDTO{


   private Long id;

   @NotBlank
   private String name;

   @NotBlank
   private String dean;

   @NotBlank
   private String universityName;
}
