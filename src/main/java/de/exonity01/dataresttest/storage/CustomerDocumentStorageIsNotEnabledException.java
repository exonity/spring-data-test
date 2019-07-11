package de.exonity01.dataresttest.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.METHOD_NOT_ALLOWED)
public class CustomerDocumentStorageIsNotEnabledException extends RuntimeException {
}
