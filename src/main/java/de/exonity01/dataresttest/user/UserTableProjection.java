package de.exonity01.dataresttest.user;

import lombok.Data;

@Data
public class UserTableProjection {

    private long id;

    private String name;

    private String surname;

    private String nameSurnameId;

}
