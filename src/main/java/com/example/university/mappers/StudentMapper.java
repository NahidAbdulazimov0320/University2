package com.example.university.mappers;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface StudentMapper extends MainMapper<StudentDTO, Student> {

}
