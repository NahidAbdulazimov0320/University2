package com.example.university.mappers;

import com.example.university.dto.UniversityDTO;
import com.example.university.entity.University;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface UniversityMapper {


    UniversityDTO toDto(University university);
    University DtoTo(UniversityDTO universityDTO);

    University toEntity(UniversityDTO dto); // create new one
    University toEntity(@MappingTarget University entity, UniversityDTO dto); // takes entity, then update using dtp



}
