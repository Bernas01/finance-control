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

import com.example.repository.AccountRepository;

import jakarta.validation.Valid;
import lombok.extern.slf4j.Slf4j;



@RestController
@RequestMapping("/account")
@Slf4j

public class AccountController {
    
    @Autowired 
    AccountRepository repository;

    @GetMapping
    public List<AccountRepository> index() {
        return repository.findAll();

    }
    @PostMapping
    @ResponseStatus(CREATED)
    public AccountRepository create(@RequestBody @Valid AccountRepository account) {
        return repository.save(account);
    }

    @GetMapping("{id}")
    public ResponseEntity<AccountRepository> show(@PathVariable Long id) { 
        log.info("Retrieve Account by id {}." + id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("{id}")
    @ResponseStatus(NO_CONTENT)
    public void destroy(@PathVariable Long id) { 
        log.info("Deleting User by id {}." + id);

        verifyIfExists(id);
        repository.deleteById(id);


    }

    private void verifyIfExists(Long id) { 
        repository 
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND,"User not Found..."));
                
    }

}
    

