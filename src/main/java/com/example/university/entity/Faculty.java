package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@NoArgsConstructor
@AllArgsConstructor
@Entity
public class Faculty extends MainEntity{

    private String name;
    private String surname;

    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;

}
