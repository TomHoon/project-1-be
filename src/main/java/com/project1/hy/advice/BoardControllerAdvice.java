package com.project1.hy.advice;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project1.hy.exceptions.template.CommonExceptionTemplate;
import com.project1.hy.utils.ApiResponse;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class BoardControllerAdvice {
  
  @ExceptionHandler(CommonExceptionTemplate.class)
  public ResponseEntity<ApiResponse<Map<String, Object>>> handlerBoardException(CommonExceptionTemplate t) {
    log.error("Board Exception : {}", t.getMessage());

    Map<String, Object> body = new HashMap<>();
    body.put("message", t.getMessage());
    body.put("code", t.getCode());

    return ResponseEntity.badRequest().body(ApiResponse.error(body));

  }
}
