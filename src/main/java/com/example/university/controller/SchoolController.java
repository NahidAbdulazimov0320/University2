package com.example.university.controller;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.service.MainService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/schools")
public class SchoolController extends MainController<SchoolDTO, Long, School> {
    public SchoolController(MainService<SchoolDTO, Long, School> service) {
        super(service);
    }
}

