package com.example.university.service;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import com.example.university.mappers.UniversityMapper;
import com.example.university.repository.UniversityRepository;
import org.springframework.stereotype.Service;

@Service
public class UniversityService extends MainService<UniversityRepository, UniversityDTO, Long, University, UniversityMapper> {

    public UniversityService(UniversityRepository repository, UniversityMapper mapper) {
        super(repository, mapper);
    }
}



