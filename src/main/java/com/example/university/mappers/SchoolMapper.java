package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends MainMapper<SchoolDTO, School>{



}
