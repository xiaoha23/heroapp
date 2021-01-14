package com.galvanize.heroapp.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class APIExceptionHandler {


    @ExceptionHandler(APIEexception.class)
    public ResponseEntity<Object> handleAPIEexception(APIEexception apiEexception){
        return new ResponseEntity<>(apiEexception.getErroMsg(),HttpStatus.NOT_FOUND);
    }

}
