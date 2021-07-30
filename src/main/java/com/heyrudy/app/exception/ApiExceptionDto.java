package com.heyrudy.app.exception;

import org.springframework.http.HttpStatus;

public final class ApiExceptionDto {

    private String message;
    private HttpStatus status;

    public ApiExceptionDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }
}
