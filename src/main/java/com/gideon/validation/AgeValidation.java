package com.gideon.validation;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import org.hibernate.validator.internal.engine.constraintvalidation.ConstraintValidatorContextImpl;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class AgeValidation implements ConstraintValidator<Age, Date>{

    @Override
    public boolean isValid(Date value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        long diff = new Date().getTime() - value.getTime();
        int age = (int) (TimeUnit.MILLISECONDS.toDays(diff) / 365);
        boolean result = (age < 18) ? false : true;
         return result;
        
    }
    
}
