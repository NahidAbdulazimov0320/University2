package com.example.university.service;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import com.example.university.mappers.EnrollmentMapper;
import com.example.university.repository.EnrollmentRepository;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentService extends MainService<EnrollmentRepository, EnrollmentDTO, Long, Enrollment, EnrollmentMapper> {

    public EnrollmentService(EnrollmentRepository repository, EnrollmentMapper mapper) {
        super(repository, mapper);
    }
}
