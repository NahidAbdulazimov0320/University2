package com.example.university.mappers;

import com.example.university.dto.ProgramDTO;
import com.example.university.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

//@Mapper(config = CentralConfig.class)
@Mapper(componentModel = "spring")


public interface ProgramMapper extends MainMapper<ProgramDTO, Program> {



}
