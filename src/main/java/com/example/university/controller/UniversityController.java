package com.example.university.controller;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import com.example.university.mappers.UniversityMapper;
import com.example.university.repository.UniversityRepository;
import com.example.university.service.UniversityService;
import jakarta.persistence.Inheritance;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.lang.annotation.Inherited;

@RestController
@RequiredArgsConstructor

@RequestMapping("/universities")
public class UniversityController extends MainController<UniversityDTO, Long, University, UniversityRepository, UniversityMapper, UniversityService> {


}
