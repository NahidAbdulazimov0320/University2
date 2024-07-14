package com.example.university.repository;


import com.example.university.entity.main_entities.University;
import org.hibernate.query.Page;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import javax.swing.*;
import java.awt.print.Pageable;

@Repository
public interface UniversityRepository extends JpaRepositoryImplementation<University, Long>{


}
