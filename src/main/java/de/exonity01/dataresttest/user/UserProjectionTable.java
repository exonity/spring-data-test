package de.exonity01.dataresttest.user;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.rest.core.config.Projection;

@Projection(name = "table", types = {User.class})
public interface UserProjectionTable {

    long getId();

    String getName();

    String getSurname();

    @Value("#{target.name}")
    String getNameSurname();

}
