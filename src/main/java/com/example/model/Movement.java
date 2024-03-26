package com.example.model;


import java.math.BigDecimal;
import java.time.LocalDate;

import com.example.validation.MovementType;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
@Entity
public class Movement {

    @Id @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @NotBlank(message = "{movement.description.notBlank}")
    @Size(min = 3, max = 255, message = "{movement.description.size}")
    private String description;

    @Positive(message = "{movement.amount.positive}")
    private BigDecimal amount;

    private LocalDate date;

    @MovementType
    private String type;
    
}
