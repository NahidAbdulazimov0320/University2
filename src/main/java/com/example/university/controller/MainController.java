package com.example.university.controller;

import com.example.university.dto.MainDTO;
import com.example.university.entity.MainEntity;
import com.example.university.mappers.MainMapper;
import com.example.university.repository.MainRepository;
import com.example.university.service.MainService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.lang.annotation.Inherited;
import java.util.List;


@RestController
@RequiredArgsConstructor
public abstract class MainController<D extends MainDTO, ID extends Long, E extends MainEntity, R extends MainRepository<E, Long>, M extends MainMapper<D, E>, S extends MainService<R, D, ID, E, M>> {
    /*
    D -> DTO
    S -> Service
    ID -> id
    E -> Entity
     */
    S service;


    @GetMapping
    public List<D> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PostMapping
    @Transactional  // Atomicity -> either add all, or none
    @ResponseStatus(HttpStatus.CREATED)
    public D create(@RequestBody @Valid D element) {
        return service.create(element);
    }

    @PutMapping("/{id}")
    @Transactional
    public D updateById(@PathVariable ID id, @RequestBody @Valid D element) {
        return service.updateById(id, element);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

}
