package com.example.university.service;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Service;

@Service
public class UniversityService extends MainService<UniversityDTO, Long, University> {
    public UniversityService(JpaRepositoryImplementation<University, Long> repository, MainMapper<UniversityDTO, University> mapper) {
        super(repository, mapper);
    }


}



