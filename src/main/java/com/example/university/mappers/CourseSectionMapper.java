package com.example.university.mappers;

import com.example.university.dto.CourseSectionDTO;
import com.example.university.entity.CourseSection;
import org.mapstruct.Mapper;

@Mapper
public interface CourseSectionMapper {

    CourseSectionDTO courseSectionToCourseSectionDTO(CourseSection courseSection);
    CourseSection courseSectionDTOToCourseSection(CourseSectionDTO courseSectionDTO);

}
