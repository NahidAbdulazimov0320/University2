package com.example.university.controller;

import com.example.university.entity.MainEntity;
import com.example.university.service.MainService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
public abstract class MainController<D, ID extends Long, E extends MainEntity> {

    /*
    D -> DTO
    S -> Service
    ID -> id
    E -> Entity
     */
    private final MainService<D, ID, E> service;

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
