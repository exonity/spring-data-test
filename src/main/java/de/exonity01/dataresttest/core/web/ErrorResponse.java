package de.exonity01.dataresttest.core.web;

import de.exonity01.dataresttest.core.exceptions.InternalErrorCode;
import lombok.Builder;
import lombok.Getter;

@Getter
@Builder
public class ErrorResponse {

    private InternalErrorCode internalErrorCode = InternalErrorCode.Undefined;

    private String message;

}
