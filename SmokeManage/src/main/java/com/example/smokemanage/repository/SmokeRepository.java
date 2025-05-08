package com.example.smokemanage.repository;

import com.example.smokemanage.entity.Smoke;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface SmokeRepository extends JpaRepository<Smoke, Long> {
}
