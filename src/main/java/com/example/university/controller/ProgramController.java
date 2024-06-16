package com.example.university.controller;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import com.example.university.service.MainService;
import com.example.university.service.ProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/programs")
public class ProgramController extends MainController<ProgramDTO, Long , Program>{


    public ProgramController(MainService<ProgramDTO, Long, Program> service) {
        super(service);
    }
}
