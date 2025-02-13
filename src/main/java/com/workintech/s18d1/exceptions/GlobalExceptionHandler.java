package com.workintech.s18d1.exceptions;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Slf4j
public class GlobalExceptionHandler {

    @ExceptionHandler(BurgerException.class)
    public ResponseEntity<BurgerErrorResponse> handleException(BurgerException burgerException)
    {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(burgerException.getHttpStatus().value(),
                burgerException.getMessage(),
                System.currentTimeMillis());
        log.error(String.format("A error occured: ",burgerException.getMessage()));
        return new ResponseEntity<BurgerErrorResponse>(errorResponse,burgerException.getHttpStatus());
    }

    @ExceptionHandler(Exception.class)
    public ResponseEntity<BurgerErrorResponse> handleException(Exception exception)
    {
        BurgerErrorResponse errorResponse = new BurgerErrorResponse(HttpStatus.INTERNAL_SERVER_ERROR.value(), exception.getMessage(),
                System.currentTimeMillis());
        log.error(String.format("A error occured: ",exception.getMessage()));
        return new ResponseEntity<BurgerErrorResponse>(errorResponse,HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
