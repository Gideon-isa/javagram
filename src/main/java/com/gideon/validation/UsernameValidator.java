package com.gideon.validation;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import jakarta.validation.ConstraintValidator;
import jakarta.validation.ConstraintValidatorContext;

public class UsernameValidator implements ConstraintValidator<Username, String> {

    @Override
    public boolean isValid(String value, ConstraintValidatorContext context) {
        // TODO Auto-generated method stub
        Pattern pattern = Pattern.compile("[^a-z0-9]");
        Matcher matcher = pattern.matcher(value); 
        boolean badCharacters = matcher.find() ? true: false;
        return badCharacters;

        //throw new UnsupportedOperationException("Unimplemented method 'isValid'");
    }

    
}
