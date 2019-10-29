package de.exonity01.dataresttest.core.exceptions;

import com.mysema.commons.lang.Assert;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class CustomException extends RuntimeException {

    private HttpStatus httpStatus;

    private InternalErrorCode internalErrorCode = InternalErrorCode.Undefined;

    private String message;

    private Throwable cause;

    public CustomException(HttpStatus httpStatus, InternalErrorCode internalErrorCode) {
        Assert.notNull(httpStatus, "httpStatus must not be null!");
        Assert.notNull(internalErrorCode, "internalErrorCode must not be null!");

        this.internalErrorCode = internalErrorCode;
    }

    public CustomException(HttpStatus httpStatus, InternalErrorCode internalErrorCode, String message) {
        Assert.notNull(httpStatus, "httpStatus must not be null!");
        Assert.notNull(internalErrorCode, "internalErrorCode must not be null!");

        this.internalErrorCode = internalErrorCode;
        this.message = message;
    }

    public CustomException(HttpStatus httpStatus, InternalErrorCode internalErrorCode, String message, Throwable cause) {
        Assert.notNull(httpStatus, "httpStatus must not be null!");
        Assert.notNull(internalErrorCode, "internalErrorCode must not be null!");

        this.internalErrorCode = internalErrorCode;
        this.message = message;
        this.cause = cause;
    }

    public CustomException(HttpStatus httpStatus, InternalErrorCode internalErrorCode, Throwable cause) {
        Assert.notNull(httpStatus, "httpStatus must not be null!");
        Assert.notNull(internalErrorCode, "internalErrorCode must not be null!");

        this.internalErrorCode = internalErrorCode;
        this.cause = cause;
    }

}
