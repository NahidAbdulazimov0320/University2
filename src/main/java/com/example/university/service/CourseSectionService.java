package com.example.university.service;

import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import com.example.university.mappers.MainMapper;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;

@Service
public class CourseSectionService extends MainService<CourseSectionDTO, Long, CourseSection> {
    public CourseSectionService(JpaRepository<CourseSection, Long> repository, MainMapper<CourseSectionDTO, CourseSection> mapper) {
        super(repository, mapper);
    }
}
