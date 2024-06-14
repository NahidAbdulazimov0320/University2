package com.example.university.service;

import com.example.university.dto.MainDTO;
import com.example.university.entity.MainEntity;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.MainMapper;
import com.example.university.repository.MainRepository;
import lombok.RequiredArgsConstructor;

import java.util.List;

@RequiredArgsConstructor
public abstract class MainService<R extends MainRepository<O, Long>, D extends MainDTO, ID extends Long, O extends MainEntity, M extends MainMapper<D, O>> {

    /*
    R -> repository
    D -> DTO
    ID -> id
    O -> Object
    M -> mapper
     */
    private final R repository;
    private final M mapper;


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


    public D create(D element) {
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
