package de.exonity01.dataresttest.user;

import lombok.Builder;
import lombok.Getter;
import lombok.NonNull;

import javax.persistence.*;

@Entity
@Builder
@Getter
// @NoArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @NonNull
    private String name;

    @NonNull
    private String surname;

    @Embedded
    private Address address;

}
