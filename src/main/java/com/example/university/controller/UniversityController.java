package com.example.university.controller;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import com.example.university.mappers.MainMapper;
import com.example.university.mappers.UniversityMapper;
import com.example.university.model.validation.ValidUniversity;
import com.example.university.repository.UniversityRepository;
import com.example.university.service.MainService;
import com.example.university.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/universities")
//TODO
public class UniversityController extends MainController<UniversityDTO, Long, University>{
    public UniversityController(MainService<UniversityDTO, Long, University> service) {
        super(service);
    }
}
