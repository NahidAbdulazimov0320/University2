package com.example.university.service;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import com.example.university.mappers.ProgramMapper;
import com.example.university.repository.ProgramRepository;
import org.springframework.stereotype.Service;


@Service
public class ProgramService extends MainService<ProgramRepository, ProgramDTO, Long, Program, ProgramMapper> {

    public ProgramService(ProgramRepository repository, ProgramMapper mapper) {
        super(repository, mapper);
    }
}
