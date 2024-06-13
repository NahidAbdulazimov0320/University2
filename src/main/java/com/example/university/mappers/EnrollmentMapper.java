package com.example.university.mappers;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import org.mapstruct.Mapper;

@Mapper
public interface EnrollmentMapper {

    EnrollmentDTO enrollmentToEnrollmentDTO(Enrollment enrollment);
    Enrollment enrollmentDTOToEnrollment(EnrollmentDTO enrollmentDTO);

}
