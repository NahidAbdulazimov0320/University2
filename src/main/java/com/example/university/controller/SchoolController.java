package com.example.university.controller;

import com.example.university.dto.SchoolDTO;
import com.example.university.model.validation.ValidSchool;
import com.example.university.service.SchoolService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController

@RequestMapping("/schools")
public class SchoolController implements BasicControllerMethods<SchoolDTO, Long> {

    private final SchoolService service;

    @Override
    @GetMapping
    public List<SchoolDTO> getAll() {
        return service.getAll();
    }

    @Override
    @GetMapping("/{id}")
    public SchoolDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    @Override
    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDTO create(@RequestBody @Valid SchoolDTO dto) {
        return service.create(dto);
    }

    @Validated(ValidSchool.class)
    @Override
    @PutMapping("/{id}")
    public SchoolDTO updateById(@PathVariable Long id, @RequestBody @Valid SchoolDTO dto) {
        return service.updateById(id, dto);
    }

    @Override
    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

