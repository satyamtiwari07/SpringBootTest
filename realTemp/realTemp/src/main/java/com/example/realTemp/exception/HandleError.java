package com.example.realTemp.exception;

import com.example.realTemp.service.DriverServiceImpl;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@ControllerAdvice
public class HandleError {
    Logger logger = LoggerFactory.getLogger(HandleError.class);
    @ExceptionHandler
    public ResponseEntity<DriverErrorResponse> DriverNotFoundError(DriverNotFoundException ex){
        logger.info("Inside global-Exeception Class (handle Error)");
        DriverErrorResponse error = new DriverErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseEntity<Map<String, List<String>>> handleValidationErrors(MethodArgumentNotValidException ex) {
        logger.info("Inside global-Exeception Class (handle Error)");
        List<String> errors = new ArrayList<>();
        for (ObjectError error : ex.getBindingResult().getAllErrors()) {
            errors.add(error.getDefaultMessage());
        }
        return new ResponseEntity<>(getErrorsMap(errors), new HttpHeaders(), HttpStatus.BAD_REQUEST);
    }

    private Map<String, List<String>> getErrorsMap(List<String> errors) {
          Map<String, List<String>> errorResponse = new HashMap<>();
          errorResponse.put("errors", errors);
          return errorResponse;
    }

    @ExceptionHandler
    public ResponseEntity<VehicalErrorResponse> VehicalNotFoundError(VehicalNotFoundException ex){

        logger.info("Inside global-Exeception Class (handle Error)");
        VehicalErrorResponse error = new VehicalErrorResponse();
        error.setStatus(HttpStatus.NOT_FOUND);
        error.setMessage(ex.getMessage());
        error.setTimeStamp(System.currentTimeMillis());
        return new ResponseEntity<>(error,HttpStatus.NOT_FOUND);
    }

}
