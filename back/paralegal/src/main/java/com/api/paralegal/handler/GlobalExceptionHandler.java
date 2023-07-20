package com.api.paralegal.handler;

import org.apache.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
public class GlobalExceptionHandler {

    private static final Logger logger = Logger.getLogger(GlobalExceptionHandler.class);

    public ResponseEntity<?> todosLosErrores(Exception ex, WebRequest req){
        logger.error(ex.getMessage());
        return new ResponseEntity("Error "+ex.getMessage(), HttpStatus.INTERNAL_SERVER_ERROR);
    }
}
