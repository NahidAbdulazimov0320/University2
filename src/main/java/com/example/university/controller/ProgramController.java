package com.example.university.controller;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import com.example.university.mappers.ProgramMapper;
import com.example.university.repository.ProgramRepository;
import com.example.university.service.ProgramService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/programs")
public class ProgramController extends MainController<ProgramDTO, Long, Program, ProgramRepository, ProgramMapper, ProgramService> {


}
