package com.assessment.validation;

import org.springframework.stereotype.Component;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;


@Component
public class UserTypeValidator implements ConstraintValidator<ValidateNumber,String> {

    @Override
    public void initialize(final ValidateNumber constraintAnnotation) {
        //for interface
    }
    @Override
    public boolean isValid(String contactField,
                           ConstraintValidatorContext cxt) {
        boolean test =  contactField != null && contactField.matches("[0-9]+")
                && (contactField.length() > 8) && (contactField.length() < 14);
        return test;
    }
}
