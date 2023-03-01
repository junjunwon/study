package com.spring.handler;

import com.spring.exception.DataNotFoundException;
import com.spring.exception.InvalidPriceException;
import com.spring.model.response.error.ErrorResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@Slf4j
@ControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(InvalidPriceException.class)
    protected ResponseEntity<ErrorResponse> handleInvalidPriceException(InvalidPriceException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.isSuccess(), e.getDetailMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler(DataNotFoundException.class)
    protected ResponseEntity<ErrorResponse> handleDataNotFoundException(DataNotFoundException e) {
        ErrorResponse errorResponse = new ErrorResponse(e.isSuccess(), e.getDetailMessage());

        return new ResponseEntity<>(errorResponse, HttpStatus.NOT_FOUND);
    }
}
