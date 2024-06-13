package com.example.university.mappers;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

@Mapper(componentModel = "spring")
public interface ProgramMapper {

    ProgramDTO toDto(Program program);
    Program DtoTo(ProgramDTO program);

    Program toEntity(ProgramDTO programDTO);

    Program toEntity(@MappingTarget Program program, ProgramDTO programDTO);

}
