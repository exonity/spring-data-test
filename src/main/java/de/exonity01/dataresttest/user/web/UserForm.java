package de.exonity01.dataresttest.user.web;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

@Getter
class UserForm {

    @NotNull
    @Length(min = 3, max = 255)
    String name;

    @NotNull
    @Length(min = 3, max = 255)
    String surname;

    @NotNull
    @Valid
    AddressForm address;

}
