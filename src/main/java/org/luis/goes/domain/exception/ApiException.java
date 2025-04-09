package org.luis.goes.domain.exception;

public class ApiException {

    public static abstract class HttpException extends RuntimeException {
        private final int statusCode;

        public HttpException(String message, int statusCode) {
            super(message);
            this.statusCode = statusCode;
        }

        public int getStatusCode() {
            return statusCode;
        }
    }

    public static class NotFound extends HttpException {
        public NotFound(String message) {
            super(message, 404);
        }
    }

    public static class BadRequest extends HttpException {
        public BadRequest(String message) {
            super(message, 400);
        }
    }

    public static class Unauthorized extends HttpException {
        public Unauthorized(String message) {
            super(message, 401);
        }
    }

    public static class Forbidden extends HttpException {
        public Forbidden(String message) {
            super(message, 403);
        }
    }

}