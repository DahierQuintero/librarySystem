package com.test.librarySystem.exceptions;

import lombok.Builder;
import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
@Builder
public class ApiException {
    private String message;
    private HttpStatus statusCode;
}
