package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.DayOfWeek;
import java.time.Duration;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class SectionSchedule {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;


    @ManyToOne
    @JoinColumn(name = "section_id")
    private CourseSection courseSection;

    @Enumerated(EnumType.STRING)
    private DayOfWeek dayOfWeek;



    private LocalTime startTime;
    private Duration duration;
    private LocalTime endTime;

}
