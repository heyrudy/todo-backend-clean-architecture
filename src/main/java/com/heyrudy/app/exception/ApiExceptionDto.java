package com.heyrudy.app.exception;

import org.springframework.http.HttpStatus;

public final record ApiExceptionDto(String message, HttpStatus status) { }
