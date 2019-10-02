package de.exonity01.dataresttest.customer.web;

import lombok.Getter;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

@Getter
public class CustomerCreateDto {

    @NotNull
    private Boolean isPrivate;

    @NotNull
    @Size(min = 3, max = 255)
    private String name;

    @NotNull
    @Size(min = 3, max = 255)
    private String surname;

    @Size(min = 3, max = 255)
    private String companyName;

    @NotNull
    private String aBc;

    @NotNull
    private String abc;


}
