package com.example.lateproject.repository;

import com.example.lateproject.entity.LateHistory;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDateTime;
import java.util.List;

public interface LateHistoryRepository extends JpaRepository<LateHistory, Long> {
    List<LateHistory> findAllByDateBetween(LocalDateTime startDate, LocalDateTime endDate);
}
