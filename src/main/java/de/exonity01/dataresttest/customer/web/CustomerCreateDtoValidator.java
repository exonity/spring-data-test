package de.exonity01.dataresttest.customer.web;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

public class CustomerCreateDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerCreateDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerCreateDto customerCreateDto = (CustomerCreateDto) target;

        if (!customerCreateDto.getIsPrivate()) {
            ValidationUtils.rejectIfEmpty(errors, "companyName", "NotNull");
        }
    }

}
