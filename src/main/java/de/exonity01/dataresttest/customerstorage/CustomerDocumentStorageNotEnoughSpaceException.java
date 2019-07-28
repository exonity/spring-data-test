package de.exonity01.dataresttest.customerstorage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class CustomerDocumentStorageNotEnoughSpaceException extends RuntimeException {
}
