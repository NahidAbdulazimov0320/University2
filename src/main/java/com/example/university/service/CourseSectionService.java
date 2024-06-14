package com.example.university.service;

import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import com.example.university.mappers.CourseSectionMapper;
import com.example.university.repository.CourseSectionRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseSectionService extends MainService<CourseSectionRepository, CourseSectionDTO, Long, CourseSection, CourseSectionMapper> {
    public CourseSectionService(CourseSectionRepository repository, CourseSectionMapper mapper) {
        super(repository, mapper);
    }
}
