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
public class ProgramController implements BasicControllerMethods<ProgramDTO, Long>{

    private final ProgramService service;


    @Override
    @GetMapping
    public List<ProgramDTO> getAll() {
        return service.getAll();

    }

    @Override
    @GetMapping("/{id}")
    public ProgramDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    public ProgramDTO create(@RequestBody @Valid ProgramDTO dto) {
       return service.create(dto);
    }

    @Override
    @PutMapping("/{id}")
    public ProgramDTO updateById(@PathVariable Long id, @RequestBody @Valid ProgramDTO dto) {
        return service.updateById(id, dto);
    }

    @Override
    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);

    }
}
