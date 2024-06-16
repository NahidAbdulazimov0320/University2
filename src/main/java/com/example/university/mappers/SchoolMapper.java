package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends MainMapper<SchoolDTO, School> {


}
