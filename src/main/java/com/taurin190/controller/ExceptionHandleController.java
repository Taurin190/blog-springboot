package com.taurin190.controller;

import com.taurin190.exception.NotFoundException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Controller
public class ExceptionHandleController {

    @ExceptionHandler(NotFoundException.class)
    String handleNotFoundException(NotFoundException e) {
        return "error.html";
    }
}

