package com.test.librarySystem.exceptions.factory;

import com.test.librarySystem.exceptions.ApiException;
import org.springframework.http.HttpStatus;

public final class ExceptionFactory {

    private ExceptionFactory() {}

    public static ApiException resolve(Exception e) {
        return switch (e.getClass().getSimpleName()) {
            case "NotFoundException" -> build(e.getMessage(), HttpStatus.NOT_FOUND);
            case "MethodArgumentNotValidException",
                    "IllegalArgumentException" -> build(e.getMessage(), HttpStatus.BAD_REQUEST);
            default -> build("Internal server error", HttpStatus.INTERNAL_SERVER_ERROR);
        };
    }

    private static ApiException build(String message, HttpStatus status) {
        return ApiException.builder()
                .message(message)
                .statusCode(status)
                .build();
    }
}
