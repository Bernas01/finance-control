package com.example.model;

import lombok.Data;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Data 
@Entity
public class Financeira {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private String descricao;
    private Double valor;

}
