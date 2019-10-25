package de.exonity01.dataresttest.customer.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(HttpStatus.UNPROCESSABLE_ENTITY)
public class CustomerNotEnabledException extends RuntimeException {

    public CustomerNotEnabledException(long id) {
        super("Customer id=" + id + " is not active!");
    }

}
