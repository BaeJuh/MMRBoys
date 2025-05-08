package com.example.lateproject.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class LateStudentUpdateRequest {
    private long lateHistoryId;
    private long studentId;
}
