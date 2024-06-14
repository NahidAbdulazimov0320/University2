package com.example.university.mappers;

import com.example.university.entity.MainEntity;
import org.mapstruct.MapperConfig;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

@MapperConfig
public interface MainMapper<D, M extends MainEntity> {

    D toDto(M program);

    M toEntity(D programDTO);

    @Mapping(target = "id", ignore = true)
    M toEntity(@MappingTarget M program, D programDTO);
}
