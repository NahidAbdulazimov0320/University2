package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Course {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;
    private String description;
    private boolean isActive;

    @OneToMany
    private List<Course> preRequisite;

    @OneToMany
    private List<Course> coreRequisite;


    @OneToMany(mappedBy = "mainCourse")
    private Set<CourseSection> courseSections;


    @ManyToOne
    @JoinColumn(name = "program_id")
    private Program program;

}
