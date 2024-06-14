package com.example.university.repository;

import com.example.university.entity.Enrollment;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface EnrollmentRepository extends JpaRepositoryImplementation<Enrollment, Long> {


}
