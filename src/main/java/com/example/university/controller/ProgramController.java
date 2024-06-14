package com.example.university.controller;

import com.example.university.dto.ProgramDTO;
import com.example.university.service.ProgramService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/programs")
public class ProgramController {

    private final ProgramService service;



    @GetMapping
    public List<ProgramDTO> getAll() {
        return service.getAll();

    }


    @GetMapping("/{id}")
    public ProgramDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PostMapping
    public ProgramDTO create(@RequestBody @Valid ProgramDTO dto) {
       return service.create(dto);
    }


    @PutMapping("/{id}")
    public ProgramDTO updateById(@PathVariable Long id, @RequestBody @Valid ProgramDTO dto) {
        return service.updateById(id, dto);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);

    }
}
