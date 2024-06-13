package com.example.university.repository;

import com.example.university.entity.CourseSection;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CourseSectionRepository extends JpaRepositoryImplementation<CourseSection, Long> {
}
