package com.project1.hy.advice;

import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.project1.hy.exceptions.template.MemberExceptionTemplate;
import com.project1.hy.utils.ApiResponse;

import lombok.extern.log4j.Log4j2;

@RestControllerAdvice
@Log4j2
public class MemberControllerAdvice {

  @ExceptionHandler(MemberExceptionTemplate.class)
  public ResponseEntity<ApiResponse<Map<String, Object>>> handlerMemberException(MemberExceptionTemplate t) {
    String message = t.getMessage();

    log.info("message : {}", message);
    
    Map<String, Object> body = Map.of(
        "message", t.getMessage(),
        "code", t.getCode());

    return ResponseEntity.badRequest().body(ApiResponse.error(body));
  }
}
