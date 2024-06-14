package com.example.university.repository;

import com.example.university.entity.Student;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface StudentRepository extends MainRepository<Student, Long> {
}
