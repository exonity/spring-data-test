package de.exonity01.dataresttest.user;

import lombok.Data;

import java.util.Optional;

@Data
public class UserSearchCriteria {

    private Optional<String> name = Optional.empty();

    private Optional<String> surname = Optional.empty();

    private Optional<String> nameSurname = Optional.empty();

}
