package com.example.realTemp.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class HandleError {

    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> handlError(DriverNotFoundException dr){
        DriverErrorResponse error = new DriverErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(dr.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }
}
