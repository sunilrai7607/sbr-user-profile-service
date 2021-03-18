package com.sbr.platform.rest.api.interfaces.web.exception;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import javax.validation.ConstraintViolation;
import javax.validation.ConstraintViolationException;

@RestControllerAdvice
@Slf4j
public class ControllerExceptionAdvice {

    @ExceptionHandler(ConstraintViolationException.class)
    public ResponseEntity handleException(ConstraintViolationException exception) {
        log.error("{},{}", exception.getClass().getSimpleName(), exception.getMessage());
        String message = ((ConstraintViolation) exception.getConstraintViolations().toArray()[0]).getMessage();
        return new ResponseEntity(message, HttpStatus.BAD_REQUEST);
    }
}
