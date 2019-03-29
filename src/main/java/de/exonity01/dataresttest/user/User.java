package de.exonity01.dataresttest.user;

import com.querydsl.core.types.Projections;
import lombok.*;
import org.hibernate.annotations.Formula;

import javax.persistence.*;

@Data
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

    @Formula(value = "concat(name, ' ', surname, ' (', id, ')')")
    private String fullName;

}
