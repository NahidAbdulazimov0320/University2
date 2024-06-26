package com.example.university.entity;


import com.example.university.enums.Semester;
import jakarta.persistence.*;
import lombok.*;

import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class CourseSection extends  MainEntity{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name ="course_id")
    private Course mainCourse;


    @OneToMany(mappedBy = "courseSection")
    private List<Enrollment> enrollments = new LinkedList<>();

    @OneToMany(mappedBy = "courseSection")
    private List<SectionSchedule> sectionSchedules = new LinkedList<>();

    private int capacity;

    private Semester semester;

}
