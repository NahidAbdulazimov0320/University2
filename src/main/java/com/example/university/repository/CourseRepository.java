package com.example.university.repository;

import com.example.university.entity.Course;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface CourseRepository extends MainRepository<Course, Long> {
}
