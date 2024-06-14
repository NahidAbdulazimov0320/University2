package com.example.university.repository;

import com.example.university.dto.MainDTO;
import com.example.university.entity.MainEntity;
import org.springframework.data.jpa.repository.support.JpaRepositoryImplementation;

public interface MainRepository <E extends MainEntity, ID extends Long> extends JpaRepositoryImplementation<E,ID> {
}
