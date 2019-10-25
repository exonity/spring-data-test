package de.exonity01.dataresttest.core.validators;

import org.springframework.beans.BeanWrapperImpl;

import javax.validation.ConstraintValidator;
import javax.validation.ConstraintValidatorContext;

class NotNullIfBooleanIsTrueConstraint implements ConstraintValidator<NotNullIfBooleanIsTrue, Object> {

    private String fieldBoolean;
    private String fieldNotNull;

    public void initialize(NotNullIfBooleanIsTrue constraintAnnotation) {
        this.fieldBoolean = constraintAnnotation.fieldBoolean();
        this.fieldNotNull = constraintAnnotation.fieldNotNull();
    }

    public boolean isValid(Object value, ConstraintValidatorContext context) {

        Boolean fieldValueObject = (Boolean) new BeanWrapperImpl(value).getPropertyValue(fieldBoolean);
        Object fieldNotNullObject = new BeanWrapperImpl(value).getPropertyValue(fieldNotNull);

        if (Boolean.TRUE.equals(fieldValueObject)) {
            return fieldNotNullObject != null;
        } else {
            return true;
        }
    }


}
