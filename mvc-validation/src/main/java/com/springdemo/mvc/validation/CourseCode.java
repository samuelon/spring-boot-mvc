package com.springdemo.mvc.validation;


import jakarta.validation.Constraint;
import jakarta.validation.Payload;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy= CourseCodeConstraintValidator.class)
@Target({ElementType.METHOD, ElementType.FIELD}) //where it can be applied
@Retention(RetentionPolicy.RUNTIME) //process during runtime
public @interface CourseCode {

    //define default course code
    public String value() default "SOL"; // accepts value and defaults "SOL"

    //define default error message
    public String message() default "must start with SOL"; //can pass in custom message

    //define groups of validation codes related constraints
    public Class<?>[] groups() default {};

    //define payloads of errors and additional error messages
    public Class<? extends Payload>[] payload() default {};



}
