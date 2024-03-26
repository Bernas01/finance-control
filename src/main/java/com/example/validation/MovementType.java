package com.example.validation;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

import jakarta.validation.Constraint;
import jakarta.validation.Payload;

@Target(ElementType.FIELD)
@Constraint(validatedBy = MovementTypeApplication.class)
@Retention(RetentionPolicy.RUNTIME)
public @interface MovementType {

    String message() default "{movement.type}";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};

}
