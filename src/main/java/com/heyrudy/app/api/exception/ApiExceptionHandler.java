package com.heyrudy.app.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.Optional;

@ControllerAdvice
public final class ApiExceptionHandler {

    @ExceptionHandler(value = {ApiRequestException.class})
    public ResponseEntity<Object> handleApiRequestException(final ApiRequestException apiRequestException) {
        ApiExceptionInfos apiExceptionInfos = new ApiExceptionInfos(apiRequestException.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.status());
    }

    @ExceptionHandler(value = {DbRequestException.class})
    public ResponseEntity<Object> handleDbRequestException(final DbRequestException dbRequestException) {
        ApiExceptionInfos apiExceptionInfos = new ApiExceptionInfos(dbRequestException.getMessage(), HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.status());
    }

    @ExceptionHandler(value = {HttpMessageNotReadableException.class})
    public ResponseEntity<Object> handleHttpMessageNotReadableException(final HttpMessageNotReadableException httpMessageNotReadableException) {
        String message = Optional.ofNullable(httpMessageNotReadableException.getMessage())
                .map(s -> s.split(":")[0])
                .orElse("");
        ApiExceptionInfos apiExceptionInfos = new ApiExceptionInfos(message, HttpStatus.BAD_REQUEST);

        return new ResponseEntity<>(apiExceptionInfos, apiExceptionInfos.status());
    }
}
