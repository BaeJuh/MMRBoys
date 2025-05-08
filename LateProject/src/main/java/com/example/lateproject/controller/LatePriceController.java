package com.example.lateproject.controller;

import com.example.lateproject.entity.Student;
import com.example.lateproject.model.HistoryItem;
import com.example.lateproject.model.StudentCreateRequest;
import com.example.lateproject.model.StudentItem;
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
        return studentService.getStudent(id);
    }

    @PostMapping("/history/{id}")
    public String setHistory(@PathVariable long id) {
        StudentItem student = studentService.getStudent(id);
        lateHistoryService.setLateHistory(student);

        return "Create History";
    }

    @GetMapping("/history/all")
    public List<HistoryItem> getHistories(@RequestParam(required = false) Integer year, @RequestParam(required = false) Integer month) {
        return lateHistoryService.getHistories(
                year == null ? LocalDate.now().getYear() : year,
                month == null ? LocalDate.now().getMonthValue() : month);
    }
}
