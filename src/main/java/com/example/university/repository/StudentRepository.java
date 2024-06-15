package com.example.university.repository;

import com.example.university.entity.Student;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface StudentRepository extends JpaRepositoryImplementation<Student, Long> {
}
