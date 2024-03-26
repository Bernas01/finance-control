package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Movement;

public interface MovementRepository extends JpaRepository<Movement, Long> {
    
}
