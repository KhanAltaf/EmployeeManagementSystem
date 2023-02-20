package com.assessment.customvalidation;

import java.lang.annotation.*;

import static java.lang.annotation.RetentionPolicy.RUNTIME;

@Documented
@Retention(RUNTIME)
@Target({ElementType.FIELD,ElementType.ANNOTATION_TYPE,ElementType.TYPE_USE})
public @interface ValidEmail {
}
