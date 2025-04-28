package com.example.someting.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Entity
@Getter
@Setter
public class Data {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column
    private Integer age;

    @Column(nullable = false)
    private String shape;

    @Column(nullable = false)
    private String color;

    @Column(nullable = false)
    private LocalDate date;
}
