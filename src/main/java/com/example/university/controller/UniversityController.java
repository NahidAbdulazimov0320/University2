package com.example.university.controller;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import com.example.university.service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/universities")
public class UniversityController extends MainController<UniversityDTO, Long, University> {
    public UniversityController(MainService<UniversityDTO, Long, University> service) {
        super(service);
    }



}
