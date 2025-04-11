package org.luis.goes.presentation.exception;

import org.luis.goes.shared.helpers.StatusCode;

public record ErrorResponse(
        String message,
        int statusCode
) {

    public ErrorResponse {
    }

    public ErrorResponse(String message, StatusCode statusCode) {
        this(message, statusCode.getCode());
    }

}