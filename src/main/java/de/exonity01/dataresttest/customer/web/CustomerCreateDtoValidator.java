package de.exonity01.dataresttest.customer.web;

import org.springframework.stereotype.Component;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

@Component
public class CustomerCreateDtoValidator implements Validator {

    @Override
    public boolean supports(Class<?> clazz) {
        return CustomerCreateDto.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerCreateDto request = (CustomerCreateDto) target;

        if (!request.getIsPrivate()) {
            ValidationUtils.rejectIfEmpty(errors, "companyName", "companyName.required");
        }
    }

}
