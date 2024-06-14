package com.example.university.service;

import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;


@Service
public class EnrollmentService extends MainService<EnrollmentDTO, Long, Enrollment> {
    public EnrollmentService(JpaRepository<Enrollment, Long> repository, MainMapper<EnrollmentDTO, Enrollment> mapper) {
        super(repository, mapper);
    }
}
