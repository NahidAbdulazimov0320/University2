package com.example.university.entity;

import jakarta.annotation.Generated;
import jakarta.persistence.*;
import lombok.*;
import org.springframework.data.annotation.Persistent;

import java.time.LocalDate;
import java.util.LinkedList;
import java.util.List;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class School extends MainEntity{

    @Id
    @GeneratedValue
    private Long id;

    private String name;
    private LocalDate establishmentDate;
    private String dean;


    @OneToMany(mappedBy = "school")
    private List<Program> programs = new LinkedList<>();

    @ManyToOne
    @JoinColumn(name= "university_id")
    private University university;

    @OneToMany(mappedBy = "school")
    private List<Faculty> faculty = new LinkedList<>();

    @OneToMany(mappedBy = "school")
    private List<Staff> staff = new LinkedList<>();


}
