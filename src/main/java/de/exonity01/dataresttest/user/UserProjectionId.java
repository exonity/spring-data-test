package de.exonity01.dataresttest.user;

import org.springframework.data.rest.core.config.Projection;

@Projection(name = "id", types = {User.class})
public interface UserProjectionId {

    long getId();

}
