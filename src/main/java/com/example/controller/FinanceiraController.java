package com.example.controller;


import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.HttpStatus.NOT_FOUND;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.example.model.Financeira;
import com.example.repository.FinanceiraRepository;


@RestController
@RequestMapping("financeira")
public class FinanceiraController {

    Logger log = LoggerFactory.getLogger(getClass());

    @Autowired // CDI - Context Dependency Injection
    FinanceiraRepository repository;

    @GetMapping
    public List<Financeira> index() {
        return repository.findAll();
    }

    @PostMapping
    @ResponseStatus(code = CREATED)
    public Financeira create(@RequestBody Financeira financeira) { // binding
        log.info("cadastrando financeira " + financeira);
        repository.save(financeira);
        return financeira;
    }

    @GetMapping("{id}")
    public ResponseEntity<Financeira> show(@PathVariable Long id) {
        log.info("buscar categoria por id {} ", id);

        return repository
                .findById(id)
                .map(ResponseEntity::ok) // converte para resposta http OK
                .orElse(ResponseEntity.notFound().build());

        // var categoriaEncontrada = repository.findById(id);

        // if (categoriaEncontrada.isEmpty())
        // return ResponseEntity.notFound().build();

        // return ResponseEntity.ok(categoriaEncontrada.get());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<Object> destroy(@PathVariable Long id) {
        log.info("Apagando categoria com id {} ", id);

        verifyIfExists(id);

        repository.deleteById(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("{id}")
    public ResponseEntity<Financeira> atualizar(@PathVariable Long id, @RequestBody Financeira Financeira) {
        log.info("atualizando categoria com id {} para {}", id, Financeira);

        verifyIfExists(id);

        Financeira.setId(id);

        repository.save(Financeira);
        return ResponseEntity.ok(Financeira);

    }

    private void verifyIfExists(Long id) {
        repository
                .findById(id)
                .orElseThrow(() -> new ResponseStatusException(NOT_FOUND, "Não existe categoria com o id informado"));
    }



}
