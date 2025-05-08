package com.example.lateproject.model;

import com.example.lateproject.entity.Student;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Getter
@Setter
public class HistoryItem {
    private Long id;
    private String name;
    private String phoneNumber;
    private LocalDateTime date;

}
