package com.example.university.controller;


import com.example.university.dto.EnrollmentDTO;
import com.example.university.entity.Enrollment;
import com.example.university.service.EnrollmentService;
import com.example.university.service.MainService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/enrollments")
public class EnrollmentController extends MainController<EnrollmentDTO, Long, Enrollment>{


    public EnrollmentController(MainService<EnrollmentDTO, Long, Enrollment> service) {
        super(service);
    }
}
