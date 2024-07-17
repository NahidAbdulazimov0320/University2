package com.example.university.service.app_service;

import com.example.university.entity.main_entities.MainEntity;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.MainMapper;
import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageImpl;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
public abstract class MainService<D, ID extends Serializable, O extends MainEntity> {

    private final JpaRepositoryImplementation<O, ID> repository;
    private final MainMapper<D, O> mapper;

    private Cache<String, List<O>> cache;

    public Page<D> getAll(Pageable pageable){
        if (cache.getIfPresent("cache") != null) {
            List<D> cachedData = Objects.requireNonNull(cache.getIfPresent("cache")).stream()
                    .map(mapper::toDto)
                    .toList();
            return new PageImpl<>(cachedData, pageable, cachedData.size());
        }
        Page<O> all = repository.findAll(pageable);
        List<O> entities = all.getContent();
        cache.put("cache", entities);
        return all.map(mapper::toDto);
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


    @PostConstruct
    public void init() {
        cache = Caffeine
                .newBuilder()
                .maximumSize(100)
                .build();

    }

}
