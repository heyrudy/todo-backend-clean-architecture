package com.heyrudy.app.exception;

import org.springframework.http.HttpStatus;

public final class ApiExceptionDto {

    private String message;
    private HttpStatus status;

    public ApiExceptionDto() {
    }

    public ApiExceptionDto(String message, HttpStatus status) {
        this.message = message;
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }
}
