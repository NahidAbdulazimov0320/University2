package com.example.university.service;

import com.example.university.dto.ProgramDTO;
import com.example.university.exceptions.NoDataFound;
import com.example.university.exceptions.NoSuchEntityFoundException;
import com.example.university.mappers.ProgramMapper;
import com.example.university.repository.ProgramRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;


@RequiredArgsConstructor
@Service
public class ProgramService {

    private final ProgramRepository repository;
    private final ProgramMapper mapper;



    public List<ProgramDTO> getAll() {
        return repository
                .findAll()
                .stream()
                .map(mapper::toDto)
                .toList();
    }


    public ProgramDTO getById(Long id) {
        return repository.findById(id).map(mapper::toDto).orElseThrow(NoDataFound::new);
    }


    public ProgramDTO create(ProgramDTO dto) {
        return mapper.toDto(repository.save(mapper.DtoTo(dto)));
    }


    public ProgramDTO updateById(Long id, ProgramDTO dto) {
        return repository.findById(id)
                .map(program -> repository.save(mapper.toEntity(program, dto)))
                .map(mapper::toDto).orElseThrow(NoDataFound::new);
    }


    public void deleteById(Long id) {
        repository.delete(repository.findById(id).orElseThrow(NoDataFound::new));
    }
}
