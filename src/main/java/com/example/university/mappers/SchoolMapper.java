package com.example.university.mappers;

import com.example.university.dto.SchoolDTO;
import com.example.university.entity.School;
import com.example.university.entity.University;
import com.example.university.repository.UniversityRepository;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;
import org.springframework.beans.factory.annotation.Autowired;

@Mapper(componentModel = "spring")
public interface SchoolMapper extends MainMapper<SchoolDTO, School> {

    @Mapping(target = "university", source = "")
    @Override
    School toEntity(SchoolDTO schoolDTO);


    @Named("idToUniversity")
    default University convertIdToUniversity(Long id){
        return universityRepository.findById(schoolDTO.getUniversity_id())
                .orElseThrow(() -> new IllegalArgumentException("University not found with id: " + schoolDTO.getUniversity_id()));
    }


    @Mapping(target = "universityId", source = "school.university.id")
    @Override
    SchoolDTO toDto(School school);

}
