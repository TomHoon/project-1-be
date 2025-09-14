package com.project1.hy.advice;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import com.project1.hy.utils.ApiResponse;

@RestControllerAdvice
public class GlobalExceptionHandler {

    @ExceptionHandler(NoHandlerFoundException.class)
    public ResponseEntity<ApiResponse<Void>> handle404(NoHandlerFoundException ex) {
        ApiResponse<Void> response = new ApiResponse<>();
        response.setStatus("404");
        response.setMessage("Resource not found");
        response.setData(null);
        return new ResponseEntity<>(response, HttpStatus.NOT_FOUND);
    }
}
