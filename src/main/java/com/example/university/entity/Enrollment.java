package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDateTime;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Enrollment extends MainEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "student_id")
    private Student student;


    @ManyToOne
    @JoinColumn(name = "course_section_id")
    private CourseSection courseSection;


    private LocalDateTime enrolledTime;


}
