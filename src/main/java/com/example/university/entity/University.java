package com.example.university.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class University extends MainEntity{


    @OneToMany(mappedBy = "university")
    private List<School> schools;

    @OneToMany(mappedBy = "university")
    private List<Faculty> faculty;

    @OneToMany
    private List<Staff> staff;


    private String name;
    private String location;
    private LocalDate establishment;
    private String rector;
    private String gradingSystem;






}
