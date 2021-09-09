package com.mamoun.task.exception;

import com.mamoun.task.config.Response;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionManager {

    @ExceptionHandler({HttpServiceException.class})
    public ResponseEntity<Response> handleHttpServiceException(HttpServiceException ex) {
        Response response = new Response(ex.getStatus().value(), ex.getMessage(), null);
        return new ResponseEntity<>(response, ex.getStatus());
    }
}
