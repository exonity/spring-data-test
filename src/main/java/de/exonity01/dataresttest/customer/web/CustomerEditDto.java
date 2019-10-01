package de.exonity01.dataresttest.customer.web;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CustomerEditDto {

    @NotNull
    Boolean isPrivate;

    @NotNull
    @Size(min = 3, max = 255)
    String name;

    @NotNull
    @Size(min = 3, max = 255)
    String surname;

    @Size(min = 3, max = 255)
    String companyName;

}
