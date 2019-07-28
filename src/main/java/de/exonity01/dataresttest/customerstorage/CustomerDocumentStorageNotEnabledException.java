package de.exonity01.dataresttest.customerstorage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class CustomerDocumentStorageNotEnabledException extends RuntimeException {
}
