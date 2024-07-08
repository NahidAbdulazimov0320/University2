package com.example.university.controller;

import com.example.university.dto.FacultyDTO;
import com.example.university.entity.Faculty;
import com.example.university.service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/faculties")
public class FacultyController extends MainController<FacultyDTO, Long, Faculty> {

    public FacultyController(MainService<FacultyDTO, Long, Faculty> service) {
        super(service);
    }
}
