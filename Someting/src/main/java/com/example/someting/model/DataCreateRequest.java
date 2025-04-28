package com.example.someting.model;

import jakarta.persistence.Column;
import lombok.Getter;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
public class DataCreateRequest {
    private String name;
    private Integer age;
    private String shape;
    private String color;
}
