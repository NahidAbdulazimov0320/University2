package com.example.university.repository;

import com.example.university.entity.CourseSection;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseSectionRepository extends JpaRepositoryImplementation<CourseSection, Long> {
}
