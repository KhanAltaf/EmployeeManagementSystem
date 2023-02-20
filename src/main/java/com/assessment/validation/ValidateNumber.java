package com.assessment.validation;

import java.lang.annotation.*;
import javax.validation.Constraint;
import javax.validation.Payload;


@Target(value = {ElementType.FIELD,ElementType.PARAMETER})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Constraint(validatedBy = UserTypeValidator.class)
public @interface ValidateNumber {

    public String message() default "Invalid Phone Number";

    Class<?>[] groups() default {};

    Class<? extends Payload>[] payload() default {};
}
