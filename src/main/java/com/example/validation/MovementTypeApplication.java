package com.example.validation;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class MovementTypeApplication implements ConstraintValidator<MovementType, String>  {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        return value.equals("ENTRADA") || value.equals("SAIDA");
    }

}
