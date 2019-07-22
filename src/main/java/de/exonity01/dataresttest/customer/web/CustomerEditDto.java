package de.exonity01.dataresttest.customer.web;

import lombok.Getter;

import javax.validation.constraints.NotNull;

@Getter
public class CustomerEditDto {

    @NotNull
    String name;

    @NotNull
    String surname;

}
