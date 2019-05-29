package de.exonity01.dataresttest.user;

import lombok.*;
import org.springframework.util.Assert;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Entity
@Builder
@Getter
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String name;

    private String surname;

    @Embedded
    private Address address;

    @Builder.Default
    private boolean active = true;

    public User deactivate() {
        Assert.state(active, "User is already deactivated.");

        active = false;

        return this;
    }

}
