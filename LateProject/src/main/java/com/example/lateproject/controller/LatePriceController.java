package com.example.lateproject.controller;

import com.example.lateproject.model.*;
import com.example.lateproject.serevice.LateHistoryService;
import com.example.lateproject.serevice.StudentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("")
public class LatePriceController {
    private final StudentService studentService;
    private final LateHistoryService lateHistoryService;

    @GetMapping("/test")
    public String test() {
        return "check";
    }

    @PostMapping("/student/new")
    public String setStudent(@RequestBody StudentCreateRequest request) {
        studentService.setStudent(request);

        return "Create";
    }

    @GetMapping("/student/all")
    public List<StudentItem> getStudents() {
        return studentService.getStudents();
    }

    @GetMapping("/student/{id}")
    public StudentItem getStudent(@PathVariable long id) {
        return studentService.getStudentItem(id);
    }

    @PostMapping("/history/{id}")
    public String setHistory(@PathVariable long id) {
        StudentItem student = studentService.getStudentItem(id);
        lateHistoryService.setLateHistory(student);

        return "Create History";
    }

    @GetMapping("/history/all")
    public List<HistoryItem> getHistories(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        return lateHistoryService.getHistories(
                year == null ? LocalDate.now().getYear() : year,
                month == null ? LocalDate.now().getMonthValue() : month);
    }

    @GetMapping("/detail/{id}")
    public LateHistoryDetailResponse getHistoryDetail(@PathVariable long id) {
        return lateHistoryService.getHistoryDetail(id);
    }

    @PatchMapping("/update")
    public String updateStudent(@RequestBody LateStudentUpdateRequest request) {
        lateHistoryService.putLateStudent(request.getLateHistoryId(), studentService.getStudent(request.getStudentId()));

        return "Update";
    }
}
