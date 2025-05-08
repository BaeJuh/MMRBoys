package com.example.lateproject.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@Getter
@Setter
public class LateHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(nullable = false, name = "studentId")
    @ManyToOne(fetch = FetchType.EAGER)
    private Student student;

    @Column(nullable = false)
    private LocalDateTime date;
}
