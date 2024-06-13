package com.example.university.mappers;

import com.example.university.dto.StudentDTO;
import com.example.university.entity.Student;
import org.mapstruct.Mapper;

@Mapper
public interface StudentMapper {
    StudentDTO studentToStudentDTO(Student student);
    Student  studentDTOtoStudent(StudentDTO student);
}
