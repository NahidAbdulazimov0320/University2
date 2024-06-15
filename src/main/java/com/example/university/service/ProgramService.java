package com.example.university.service;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class ProgramService extends MainService<ProgramDTO, Long, Program> {
    public ProgramService(JpaRepositoryImplementation<Program, Long> repository, MainMapper<ProgramDTO, Program> mapper) {
        super(repository, mapper);
    }
}