package com.example.university.repository;

import com.example.university.entity.School;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepositoryImplementation<School, Long> {


}
