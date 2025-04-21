package com.ghising.crud.exceptions;


import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.lang.module.ResolutionException;

@ControllerAdvice
public class ErrorException {

    @ExceptionHandler(ResolutionException.class)
    public String handleResolutionException(ResolutionException exception, Model model) {
        model.addAttribute("message", exception.getMessage());
        return "error/404";
    }
}
