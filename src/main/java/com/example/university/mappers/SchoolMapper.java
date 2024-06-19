package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")


public interface SchoolMapper extends MainMapper<SchoolDTO, School> {

    @Override
    @Mapping(source = "university.id", target = "university_id")
    SchoolDTO toDto(School program);

    @Override
    @Mapping(source = "university_id", target = "university.id")
    School toEntity(SchoolDTO programDTO);

//    @Override
//    School toEntity(School program, SchoolDTO programDTO);
}
