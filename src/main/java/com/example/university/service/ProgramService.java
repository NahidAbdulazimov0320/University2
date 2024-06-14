package com.example.university.service;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class ProgramService extends MainService<ProgramDTO, Long, Program> {
    public ProgramService(JpaRepository<Program, Long> repository, MainMapper<ProgramDTO, Program> mapper) {
        super(repository, mapper);
    }
}