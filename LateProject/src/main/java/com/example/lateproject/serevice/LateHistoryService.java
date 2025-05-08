package com.example.lateproject.serevice;

import com.example.lateproject.entity.LateHistory;
import com.example.lateproject.entity.Student;
import com.example.lateproject.model.HistoryItem;
import com.example.lateproject.model.StudentItem;
import com.example.lateproject.repository.LateHistoryRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

@Service
@RequiredArgsConstructor
public class LateHistoryService {
    private final LateHistoryRepository lateHistoryRepository;

    public void setLateHistory(StudentItem student) {
        LateHistory lateHistory = new LateHistory();

        Student newStudent = new Student();
        newStudent.setId(student.getId());
        newStudent.setName(student.getName());
        newStudent.setPhoneNumber(student.getPhoneNumber());

        lateHistory.setStudent(newStudent);
        lateHistory.setDate(LocalDateTime.now());

        lateHistoryRepository.save(lateHistory);
    }

    public List<HistoryItem> getHistories(int year, int month) {
        LocalDateTime startDate = LocalDateTime.of(year, month, 1, 0, 0);
        LocalDateTime endDate = startDate.plusMonths(1).minusMinutes(1);

        List<LateHistory> betweenItem = lateHistoryRepository.findAllByDateBetween(startDate, endDate);
//        List<LateHistory> betweenItem = lateHistoryRepository.findAll();
        List<HistoryItem> historyItems = new LinkedList<>();

        betweenItem.forEach(item -> {
            HistoryItem history = new HistoryItem();

            history.setDate(item.getDate());
            history.setName(item.getStudent().getName());
            history.setPhoneNumber(item.getStudent().getPhoneNumber());
            history.setDate(item.getDate());

            historyItems.add(history);
        });

        return historyItems;
    }
}
