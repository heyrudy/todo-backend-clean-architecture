package com.heyrudy.app.api.exception;

import org.springframework.http.HttpStatus;

public record ApiExceptionInfos(String message, HttpStatus status) {
}
