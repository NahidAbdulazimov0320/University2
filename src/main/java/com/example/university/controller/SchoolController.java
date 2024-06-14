package com.example.university.controller;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.mappers.SchoolMapper;
import com.example.university.repository.SchoolRepository;
import com.example.university.service.SchoolService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController

@RequestMapping("/schools")
public class SchoolController extends MainController<SchoolDTO, Long, School, SchoolRepository, SchoolMapper, SchoolService> {


}

