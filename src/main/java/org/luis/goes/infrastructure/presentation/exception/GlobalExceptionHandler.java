package org.luis.goes.infrastructure.presentation.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.luis.goes.domain.exception.ApiException;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    @Override
    public Response toResponse(Throwable exception) {
        ErrorResponse error;

        if (exception instanceof ApiException.HttpException httpEx) {
            error = new ErrorResponse(httpEx.getMessage(), httpEx.getStatusCode());
            return Response.status(httpEx.getStatusCode()).entity(error).build();
        }

        exception.printStackTrace();

        error = new ErrorResponse("Internal server error. That's not your fault!", 500);
        return Response.status(500).entity(error).build();
    }

}