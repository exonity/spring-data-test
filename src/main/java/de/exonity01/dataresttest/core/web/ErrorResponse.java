package de.exonity01.dataresttest.core.web;

import de.exonity01.dataresttest.core.exceptions.InternalErrorCode;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ErrorResponse {

    private InternalErrorCode internalErrorCode = InternalErrorCode.Undefined;

    private String message;

}
