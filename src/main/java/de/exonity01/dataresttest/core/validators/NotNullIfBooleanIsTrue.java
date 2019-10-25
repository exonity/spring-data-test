package de.exonity01.dataresttest.core.validators;

import javax.validation.Constraint;
import javax.validation.Payload;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Constraint(validatedBy = NotNullIfBooleanIsTrueConstraint.class)
@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
public @interface NotNullIfBooleanIsTrue {
    String message() default "The value is required when ";
    Class<?>[] groups() default {};
    Class<? extends Payload>[] payload() default {};

    String fieldNotNull();

    String fieldBoolean();

    @Target({ElementType.TYPE})
    @Retention(RetentionPolicy.RUNTIME)
    @interface List {
        NotNullIfBooleanIsTrue[] value();
    }
}
