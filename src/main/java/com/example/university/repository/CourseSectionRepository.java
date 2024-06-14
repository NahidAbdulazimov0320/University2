package com.example.university.repository;

import com.example.university.entity.Course;
import com.example.university.entity.CourseSection;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CourseSectionRepository extends MainRepository<CourseSection, Long> {
}
