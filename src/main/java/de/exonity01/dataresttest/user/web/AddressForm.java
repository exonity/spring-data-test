package de.exonity01.dataresttest.user.web;

import lombok.Getter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotNull;

@Getter
class AddressForm {

    @NotNull
    @Length(min = 3, max = 255)
    String street;

    @NotNull
    @Length(min = 1, max = 8)
    String houseNumber;

}
