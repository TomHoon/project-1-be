package com.project1.hy.advice;

import java.util.HashMap;
import java.util.Map;
import java.util.NoSuchElementException;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MissingServletRequestParameterException;
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

    @ExceptionHandler(MissingServletRequestParameterException.class)
    public ResponseEntity<ApiResponse<Map<String, Object>>> noParameter(MissingServletRequestParameterException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "파라미터 누락");
        body.put("message", ex.getParameterName() + " 파라미터가 필요합니다.");
        return ResponseEntity.badRequest().body(ApiResponse.error(body));
    }

    @ExceptionHandler(NoSuchElementException.class)
    public ResponseEntity<ApiResponse<Map<String, Object>>> noMember(NoSuchElementException ex) {
        Map<String, Object> body = new HashMap<>();
        body.put("error", "파라미터 누락");
        body.put("message", ex.getMessage());
        return ResponseEntity.badRequest().body(ApiResponse.error(body));
    }
}
