package org.luis.goes.presentation.exception;

import jakarta.ws.rs.core.Response;
import jakarta.ws.rs.ext.ExceptionMapper;
import jakarta.ws.rs.ext.Provider;
import org.jboss.logging.Logger;
import org.luis.goes.shared.helpers.StatusCode;

@Provider
public class GlobalExceptionHandler implements ExceptionMapper<Throwable> {

    private static final Logger LOGGER = Logger.getLogger(GlobalExceptionHandler.class);

    @Override
    public Response toResponse(Throwable exception) {
        ErrorResponse error;

        if (exception instanceof ApiException.HttpException httpException) {
            error = new ErrorResponse(httpException.getMessage(), httpException.getStatusCode());
            return Response.status(httpException.getStatusCode()).entity(error).build();
        }

        error = new ErrorResponse("Internal server error. That's not your fault!", StatusCode.INTERNAL_SERVER_ERROR);
        return Response.status(StatusCode.INTERNAL_SERVER_ERROR.getCode()).entity(error).build();
    }
}
