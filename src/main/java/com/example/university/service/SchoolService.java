package com.example.university.service;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class SchoolService extends MainService<SchoolDTO, Long, School> {
    public SchoolService(JpaRepository<School, Long> repository, MainMapper<SchoolDTO, School> mapper) {
        super(repository, mapper);
    }
}
