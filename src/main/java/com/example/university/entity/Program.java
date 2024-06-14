package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

import java.util.List;


@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Program extends MainEntity{

    private String name;

    @OneToMany(mappedBy = "program")
    private List<Course> courses;

    @OneToMany(mappedBy = "program")
    private List<Student> students;

    @ManyToOne
    @JoinColumn(name ="school_id")
    private School school;




}
