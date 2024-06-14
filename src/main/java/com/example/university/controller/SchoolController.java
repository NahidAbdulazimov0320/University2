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
public class SchoolController  {

    private final SchoolService service;


    @GetMapping
    public List<SchoolDTO> getAll() {
        return service.getAll();
    }


    @GetMapping("/{id}")
    public SchoolDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }


    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public SchoolDTO create(@RequestBody @Valid SchoolDTO dto) {
        return service.create(dto);
    }



    @PutMapping("/{id}")
    public SchoolDTO updateById(@PathVariable Long id, @RequestBody @Valid SchoolDTO dto) {
        return service.updateById(id, dto);
    }


    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }
}

