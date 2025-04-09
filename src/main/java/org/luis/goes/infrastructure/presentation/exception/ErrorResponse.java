package org.luis.goes.infrastructure.presentation.exception;

public record ErrorResponse(
        String message,
        int statusCode
) {
    public ErrorResponse(String message, int statusCode) {
        this.message = message;
        this.statusCode = statusCode;
    }
}
