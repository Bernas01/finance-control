package com.example.controller;

import static org.springframework.http.HttpStatus.CREATED;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;


import com.example.model.Movement;
import com.example.repository.MovesRepository;
import jakarta.validation.Valid;

@RestController 
@RequestMapping("movement")
public class MovementController {

    @Autowired
    MovesRepository repository;


    @PostMapping
    @ResponseStatus(CREATED)
    public Movement create(@RequestBody @Valid Movement movement) {
        return repository.save(movement);
    }
}
    