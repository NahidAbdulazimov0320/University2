package com.example.university.entity;

import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
@Entity
public class Staff extends MainEntity {


    @ManyToOne
    @JoinColumn(name = "school_id")
    private School school;
}
