package com.example.university.repository;

import com.example.university.entity.Course;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface CourseRepository extends JpaRepositoryImplementation<Course, Long> {
}
