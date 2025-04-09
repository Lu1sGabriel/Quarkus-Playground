package org.luis.goes.infrastructure.presentation.exception;

import org.luis.goes.domain.exception.StatusCode;

public record ErrorResponse(
        String message,
        int statusCode
) {
    public ErrorResponse(String message, StatusCode statusCode) {
        this(message, statusCode.getCode());
    }
}