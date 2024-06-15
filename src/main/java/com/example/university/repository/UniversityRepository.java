package com.example.university.repository;


import com.example.university.entity.University;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface UniversityRepository extends JpaRepositoryImplementation<University, Long> {


}
