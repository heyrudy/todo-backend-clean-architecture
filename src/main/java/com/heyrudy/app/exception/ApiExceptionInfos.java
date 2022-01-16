package com.heyrudy.app.exception;

import org.springframework.http.HttpStatus;

public record ApiExceptionInfos(String message, HttpStatus status) {
}
