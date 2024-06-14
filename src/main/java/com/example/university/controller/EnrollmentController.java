package com.example.university.controller;


import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import com.example.university.mappers.EnrollmentMapper;
import com.example.university.repository.EnrollmentRepository;
import com.example.university.service.EnrollmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/enrollments")
public class EnrollmentController extends MainController<EnrollmentDTO, Long, Enrollment, EnrollmentRepository, EnrollmentMapper, EnrollmentService> {


}
