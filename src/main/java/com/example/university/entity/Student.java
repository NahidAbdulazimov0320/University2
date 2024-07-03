package com.example.university.entity;


import jakarta.persistence.*;
import lombok.*;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Student extends MainEntity{

    private String name;
    private String surname;
    private String email;
    private String address;
    private String phoneNumber;


    @OneToMany(mappedBy = "student")
    private Set<Enrollment> enrollments = new HashSet<>();


    @ManyToOne
    @JoinColumn(name="program_id")
    private Program program;

}
