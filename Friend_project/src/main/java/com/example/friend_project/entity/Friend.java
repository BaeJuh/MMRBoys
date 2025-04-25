package com.example.friend_project.entity;

import jakarta.persistence.*;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Setter
public class Friend {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @Column(nullable = false)
    private String name;

    @Column
    private int age;

    @Column
    private String give;

    @Column
    private String take;

    @Column(nullable = false)
    private LocalDate date;
}
