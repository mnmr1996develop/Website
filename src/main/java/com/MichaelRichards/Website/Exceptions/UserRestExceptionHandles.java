package com.MichaelRichards.Website.Exceptions;


import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class UserRestExceptionHandles {

    public UserRestExceptionHandles() {
    }

    public ResponseEntity<UserErrorResponse> handleException(Exception e) {
        UserErrorResponse error = new UserErrorResponse(HttpStatus.BAD_REQUEST.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<UserErrorResponse>(error, HttpStatus.BAD_REQUEST);
    }

    @ExceptionHandler
    public ResponseEntity<UserErrorResponse> handleException(UserNotFoundException e){
        UserErrorResponse error = new UserErrorResponse(HttpStatus.NOT_FOUND.value(), e.getMessage(), System.currentTimeMillis());
        return new ResponseEntity<UserErrorResponse>(error, HttpStatus.NOT_FOUND);
    }
}
