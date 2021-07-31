package com.heyrudy.app.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(final ApiRequestException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        ApiExceptionDto apiException = new ApiExceptionDto(e.getMessage(), badRequest);

        return new ResponseEntity<>(apiException, badRequest);
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleHttpMessageNotReadableException(final HttpMessageNotReadableException e) {
        HttpStatus badRequest = HttpStatus.BAD_REQUEST;
        String message = Optional.ofNullable(e.getMessage())
                .map(s -> s.split(":")[0])
                .orElse("");
        ApiExceptionDto apiException = new ApiExceptionDto(message, badRequest);

        return new ResponseEntity<>(apiException, badRequest);
    }
}
