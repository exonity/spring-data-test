package de.exonity01.dataresttest.user;

import lombok.*;

import javax.persistence.*;

@Getter @Setter
@RequiredArgsConstructor
@NoArgsConstructor
@Entity
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private long id;

    @NonNull
    @Column(name = "name")
    private String name;

    @NonNull
    @Column(name = "surname")
    private String surname;

    @Column(name = "enabled")
    private boolean enabled = false;

}
