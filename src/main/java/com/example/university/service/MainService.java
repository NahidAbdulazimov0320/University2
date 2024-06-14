package com.example.university.service;

import com.example.university.entity.MainEntity;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.JpaRepository;

import java.io.Serializable;
import java.util.List;

@RequiredArgsConstructor
public abstract class MainService<D, ID extends Serializable, O extends MainEntity> {


    private final JpaRepository<O, ID> repository;
    private final MainMapper<D, O> mapper;


    public List<D> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    public D getById(ID id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(NoDataFound::new);
    }


    public D create(D element) { //optional initializers?
        return mapper.toDto(repository.save(mapper.toEntity(element)));
    }


    public D updateById(ID id, D element) {
        return repository
                .findById(id)
                .map(object -> repository.save(mapper.toEntity(object, element)))
                .map(mapper::toDto).orElseThrow(NoDataFound::new);
    }


    public void deleteById(ID id) {
        repository.delete(repository.findById(id).orElseThrow(NoDataFound::new));
    }


}
