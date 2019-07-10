package de.exonity01.dataresttest.storage;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class DocumentTooLargeException extends RuntimeException {
}
