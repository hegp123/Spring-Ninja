package com.g2.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
    
    public static final String InternalServiceError_VIEW ="error/500";
    
    @ExceptionHandler(Exception.class)
    public String showInternalServerError() {
        
        return InternalServiceError_VIEW;
    }

}
