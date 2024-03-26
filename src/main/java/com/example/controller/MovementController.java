package com.example.controller;

import static org.springframework.http.HttpStatus.*;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Movement;
import com.example.repository.MovementRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;


@RestController 
@RequestMapping("movement")
@Slf4j

public class MovementController {

    @Autowired
    MovementRepository repository;

    @GetMapping
    public List<Movement> index(){
        return repository.findAll();
    }


    @PostMapping
    @ResponseStatus(CREATED)
    public Movement create(@RequestBody @Valid Movement movement) {
        return repository.save(movement);
    }

    @GetMapping("{id}")
    public ResponseEntity<Movement> show(@PathVariable Long id) {
        log.info("Retrieve movement by id {}." + id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
                    
    }
    
    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable long id) { 
        log.info("Deleting Movement by id {}." + id);

        verifyIfExists(id);
        repository.deleteById(id);
    }

    private void verifyIfExists(Long id) { 
        repository 
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Movement not found..."));

    }

}
    
