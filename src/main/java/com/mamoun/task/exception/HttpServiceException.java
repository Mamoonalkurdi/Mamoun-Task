package com.mamoun.task.exception;

import org.springframework.http.HttpStatus;

public class HttpServiceException extends RuntimeException{

    private HttpStatus status;
    private String message;

    public HttpServiceException(HttpStatus status, String message) {
        this.status = status;
        this.message = message;
    }

    public HttpStatus getStatus() {
        return status;
    }

    public void setStatus(HttpStatus status) {
        this.status = status;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
