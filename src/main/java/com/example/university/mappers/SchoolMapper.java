package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.entity.University;
import com.example.university.repository.UniversityRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends MainMapper<SchoolDTO, School> {



}
