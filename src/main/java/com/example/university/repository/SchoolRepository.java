package com.example.university.repository;

import com.example.university.entity.School;
import com.example.university.entity.University;
import lombok.RequiredArgsConstructor;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface SchoolRepository extends JpaRepositoryImplementation<School, Long> {
    @Query(value = "update School set university = :value1 where university_id = :value2",nativeQuery = true)
    void addForeignKey(@Param("value1") University value1, @Param("value2") Long value2);

}
