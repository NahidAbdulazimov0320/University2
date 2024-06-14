package com.example.university.mappers;

import com.example.university.dto.MainDTO;
import com.example.university.dto.ProgramDTO;
import com.example.university.entity.MainEntity;
import com.example.university.entity.Program;
import org.mapstruct.Mapper;
import org.mapstruct.MappingTarget;

public interface MainMapper <D extends MainDTO, M extends MainEntity> {

    D toDto(M program);
    M toEntity(D programDTO);

    M toEntity(@MappingTarget M program, D programDTO);
}
