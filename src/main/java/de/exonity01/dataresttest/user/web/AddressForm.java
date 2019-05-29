package de.exonity01.dataresttest.user.web;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
class AddressForm {

    @NotNull
    @Size(min = 3, max = 255)
    String street;

    @NotNull
    @Size(min = 1, max = 8)
    String houseNumber;

}
