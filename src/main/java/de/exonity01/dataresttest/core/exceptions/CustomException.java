package de.exonity01.dataresttest.core.exceptions;

import lombok.Getter;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@Getter
@ResponseStatus(code = HttpStatus.UNPROCESSABLE_ENTITY)
public class CustomException extends RuntimeException {

    private InternalErrorCode internalErrorCode = InternalErrorCode.Undefined;

    private String message;

    private Throwable cause;

    public CustomException(InternalErrorCode internalErrorCode) {
        this.internalErrorCode = internalErrorCode;
    }

    public CustomException(InternalErrorCode internalErrorCode, String message) {
        this.internalErrorCode = internalErrorCode;
        this.message = message;
    }

    public CustomException(InternalErrorCode internalErrorCode, String message, Throwable cause) {
        this.internalErrorCode = internalErrorCode;
        this.message = message;
        this.cause = cause;
    }

    public CustomException(InternalErrorCode internalErrorCode, Throwable cause) {
        this.internalErrorCode = internalErrorCode;
        this.cause = cause;
    }

}
