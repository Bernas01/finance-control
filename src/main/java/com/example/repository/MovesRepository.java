package com.example.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.model.Movement;

public interface MovesRepository extends JpaRepository<Movement, Long> {
    
}
