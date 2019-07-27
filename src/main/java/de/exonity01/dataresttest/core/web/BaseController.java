package de.exonity01.dataresttest.core.web;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class BaseController {

    public void assertNotNull(Object o) {
        if (o == null) {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND);
        }
    }

}
