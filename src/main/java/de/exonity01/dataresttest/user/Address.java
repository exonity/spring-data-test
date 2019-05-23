package de.exonity01.dataresttest.user;

import lombok.*;

import javax.persistence.Embeddable;

@NoArgsConstructor
@AllArgsConstructor
@Builder
@Getter
@Embeddable
public class Address {

    private String street;

    private String houseNumber;

}
