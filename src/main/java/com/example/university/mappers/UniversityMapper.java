package com.example.university.mappers;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UniversityMapper extends MainMapper<UniversityDTO, University> {





}
