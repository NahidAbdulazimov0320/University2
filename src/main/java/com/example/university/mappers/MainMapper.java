package com.example.university.mappers;

import com.example.university.dto.MainDTO;
import com.example.university.entity.MainEntity;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@Mapper
public interface MainMapper<D extends MainDTO, M extends MainEntity> {

    D toDto(M program);

    M toEntity(D programDTO);

    @Mapping(target = "id", ignore = true)
    M toEntity(@MappingTarget M program, D programDTO);
}
