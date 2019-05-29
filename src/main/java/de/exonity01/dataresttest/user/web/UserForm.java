package de.exonity01.dataresttest.user.web;

import lombok.Getter;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
class UserForm {

    @NotNull
    @Size(min = 3, max = 255)
    String name;

    @NotNull
    @Size(min = 3, max = 255)
    String surname;

    @NotNull
    @Valid
    AddressForm address;

}
