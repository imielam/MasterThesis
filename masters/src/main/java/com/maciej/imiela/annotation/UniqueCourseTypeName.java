package com.maciej.imiela.annotation;

import static java.lang.annotation.ElementType.FIELD;
import static java.lang.annotation.RetentionPolicy.RUNTIME;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import javax.validation.Constraint;
import javax.validation.Payload;

@Target({ FIELD })
@Retention(RUNTIME)
@Constraint(validatedBy = { UniqueCourseTypeNameValidator.class })
public @interface UniqueCourseTypeName {

    Class<?>[] groups() default {};

    String message();

    Class<? extends Payload>[] payload() default {};

}
