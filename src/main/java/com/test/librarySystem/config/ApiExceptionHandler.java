package com.test.librarySystem.config;

import com.test.librarySystem.exceptions.ApiException;
import com.test.librarySystem.exceptions.factory.ExceptionFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(Exception.class)
    public ResponseEntity<ApiException> handleException(Exception ex) {

        ApiException apiException = ExceptionFactory.resolve(ex);

        return new ResponseEntity<>(apiException, apiException.getStatusCode());
    }
}
