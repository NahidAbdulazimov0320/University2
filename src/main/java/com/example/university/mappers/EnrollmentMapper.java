package com.example.university.mappers;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface EnrollmentMapper extends MainMapper<EnrollmentDTO, Enrollment> {



}
