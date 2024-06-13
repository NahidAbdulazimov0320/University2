package com.example.university.service;

import com.example.university.dto.UniversityDTO;
import com.example.university.exceptions.NoDataFound;
import com.example.university.mappers.UniversityMapper;
import com.example.university.repository.UniversityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.List;


@RequiredArgsConstructor
@Service
public class UniversityService {

    private final UniversityRepository repository;
    private final UniversityMapper mapper;


    @ResponseStatus(HttpStatus.FOUND)
    public List<UniversityDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }

    @ResponseStatus(HttpStatus.FOUND)
    public UniversityDTO getById(Long id) {
        return repository.findById(id)
                .map(mapper::toDto)
                .orElseThrow(NoDataFound::new);
    }


    @ResponseStatus(HttpStatus.CREATED)
    public UniversityDTO create(UniversityDTO universityDTO) {
        return mapper.toDto(repository.save(mapper.DtoTo(universityDTO)));
    }

    @ResponseStatus(HttpStatus.OK)
    public UniversityDTO updateById(Long id, UniversityDTO universityDTO) {
        return repository
                .findById(id)
                .map(university -> repository.save(mapper.toEntity(university, universityDTO))
                )
                .map(mapper::toDto).orElseThrow(NoDataFound::new);
    }

    @ResponseStatus(HttpStatus.I_AM_A_TEAPOT)
    public void deleteById(Long id) {
        repository.delete(repository.findById(id).orElseThrow(NoDataFound::new));
    }
}



