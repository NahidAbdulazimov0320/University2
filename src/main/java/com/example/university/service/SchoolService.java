package com.example.university.service;

import com.example.university.dto.SchoolDTO;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.SchoolMapper;
import com.example.university.repository.SchoolRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@RequiredArgsConstructor
@Service
public class SchoolService {

    private final SchoolRepository repository;
    private final SchoolMapper mapper;

    public List<SchoolDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDTO).toList();
    }

    public SchoolDTO getById(Long id) {
        return repository
                .findById(id)
                .map(mapper::toDTO)
                .orElseThrow(NoDataFound::new);
    }


    public SchoolDTO create(SchoolDTO schoolDTO) {
        return mapper.toDTO(repository.save(mapper.DtoTo(schoolDTO)));
    }


    public SchoolDTO updateById(Long id, SchoolDTO schoolDTO) {
        return repository
                .findById(id)
                .map(school -> repository.save(mapper.toEntity(school, schoolDTO)))
                .map(mapper::toDTO)
                .orElseThrow(NoDataFound::new);
    }


    public void deleteById(Long id){
        repository.delete(repository.findById(id).orElseThrow(NoDataFound::new));
    }

}
