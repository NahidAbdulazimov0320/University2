package com.example.university.service;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.mappers.SchoolMapper;
import com.example.university.repository.SchoolRepository;
import org.springframework.stereotype.Service;


@Service
public class SchoolService extends MainService<SchoolRepository, SchoolDTO, Long, School, SchoolMapper> {

    public SchoolService(SchoolRepository repository, SchoolMapper mapper) {
        super(repository, mapper);
    }
}
