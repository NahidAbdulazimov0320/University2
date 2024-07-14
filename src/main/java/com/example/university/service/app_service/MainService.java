package com.example.university.service.app_service;

import com.example.university.entity.main_entities.MainEntity;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.MainMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;

@RequiredArgsConstructor
public abstract class MainService<D, ID extends Serializable, O extends MainEntity> {

    private final JpaRepositoryImplementation<O, ID> repository;
    private final MainMapper<D, O> mapper;

    // Converted to Page! Is it acceptable to do so?
    public Page<D> getAll(Pageable pageable) {
        return repository.findAll(pageable).map(mapper::toDto);

    }

    public D getById(ID id) {
        return repository
                .findById(id)
                .map(mapper::toDto)
                .orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now()));
    }

    public D create(D element) {
        return mapper.toDto(repository.save(mapper.toEntity(element)));
    }


    public D updateById(ID id, D element) {
        return repository
                .findById(id)
                .map(object -> repository.save(mapper.toEntity(object, element)))
                .map(mapper::toDto).orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now()));
    }


    public void deleteById(ID id) {
        repository.delete(repository.findById(id).orElseThrow(() -> new NoDataFound("No record found with id: " + id, LocalDateTime.now())));
    }


}
