package de.exonity01.dataresttest.user;

import org.springframework.validation.BindingResult;

import static org.springframework.validation.ValidationUtils.rejectIfEmptyOrWhitespace;

public interface UserForm {

    String getName();

    String getSurname();

    Address getAddress();

    default void validate(BindingResult errors) {
        rejectIfEmptyOrWhitespace(errors, "name", "user.name.empty");
        if (getName().length() >= 128) {
            errors.rejectValue("name", "user.name.max-length");
        }

        rejectIfEmptyOrWhitespace(errors, "surname", "user.surname.empty");
        if (getSurname().length() >= 128) {
            errors.rejectValue("name", "user.surname.max-length");
        }
    }
}
