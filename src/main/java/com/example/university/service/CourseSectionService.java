package com.example.university.service;

import com.example.university.dto.CourseDTO;
import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import com.example.university.mappers.CourseMapper;
import com.example.university.mappers.CourseSectionMapper;
import com.example.university.repository.CourseSectionRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
public class CourseSectionService extends MainService<CourseSectionRepository, CourseSectionMapper, CourseSectionDTO, Long, CourseSection>{
    public CourseSectionService(CourseSectionRepository repository, CourseSectionMapper mapper) {
        super(repository, mapper);
    }
}
