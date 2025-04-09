package org.luis.goes.infrastructure.presentation.exception;

import org.luis.goes.domain.exception.StatusCode;

public record ErrorResponse(
        String message,
        StatusCode statusCode
) {
    public ErrorResponse(String message, StatusCode statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
