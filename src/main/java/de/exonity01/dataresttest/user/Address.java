package de.exonity01.dataresttest.user;

import lombok.Builder;

import javax.persistence.Embeddable;

@Builder
@Embeddable
public class Address {

    private String street;

    private String houseNumber;

}
