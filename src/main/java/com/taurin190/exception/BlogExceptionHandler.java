package com.taurin190.exception;

import com.taurin190.exception.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;

@ControllerAdvice
public class BlogExceptionHandler {

    @ExceptionHandler(NotFoundException.class)
    String handleNotFoundException(NotFoundException e) {
        return "error.html";
    }

    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(NumberFormatException.class)
    String handleNumberFormatException(NumberFormatException e) {
        return "error.html";
    }
}

