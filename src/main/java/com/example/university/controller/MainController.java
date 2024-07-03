package com.example.university.controller;

import com.example.university.entity.MainEntity;
import com.example.university.service.MainService;
import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;


import java.io.Serializable;
import java.util.List;

@Transactional
@RequiredArgsConstructor
public abstract class MainController<D, ID extends Serializable, E extends MainEntity> {

    /*
    D -> DTO
    S -> Service
    ID -> id
    E -> Entity
     */
    private final MainService<D, ID, E> service;

    private static final Logger logger = LoggerFactory.getLogger(ProgramController.class);

    @GetMapping
    public List<D> getAll() {
        return service.getAll();
    }

    @GetMapping("/{id}")
    public D getById(@PathVariable ID id) {
        return service.getById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public D create(@RequestBody @Valid D element) {
        logger.info("Request is made to create an entity");
        return service.create(element);
    }

    @PutMapping("/{id}")
    public D updateById(@PathVariable ID id, @RequestBody @Valid D element) {
        return service.updateById(id, element);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void deleteById(@PathVariable ID id) {
        service.deleteById(id);
    }

}
