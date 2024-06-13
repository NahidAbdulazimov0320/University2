package com.example.university.controller;

import com.example.university.dto.UniversityDTO;
import com.example.university.service.UniversityService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/universities")
public class UniversityController implements BasicControllerMethods<UniversityDTO, Long> {

    private final UniversityService service;

    @GetMapping
    public List<UniversityDTO> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public UniversityDTO getById(@PathVariable Long id) {
        return service.getById(id);
    }

    // TODO HttpStatus 201
    @PostMapping
    public UniversityDTO create(@RequestBody @Valid UniversityDTO universityDTO) {
        return service.create(universityDTO);

    }

    // TOBEASKED-> How can I change the parameter that I want (let us say only location)
    @PutMapping("/{id}")
    public UniversityDTO updateById(@PathVariable Long id, @RequestBody @Valid UniversityDTO universityDTO) {
        return service.updateById(id, universityDTO);
    }

    @DeleteMapping("/{id}")
    //TODO httpstatus 204
    public void deleteById(@PathVariable Long id) {
        service.deleteById(id);
    }


}
