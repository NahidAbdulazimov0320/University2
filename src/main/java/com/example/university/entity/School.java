package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends MainEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    private String name;

    private String dean;

    private LocalDate establishmentDate;

    @ManyToOne
    @JoinColumn(name = "university_id")
    private University university;

    @OneToMany(mappedBy = "school")
    private List<Program> programs;

    @OneToMany(mappedBy = "school")
    private List<Faculty> faculty;

    @OneToMany(mappedBy = "school")
    private List<Staff> staff;


}
