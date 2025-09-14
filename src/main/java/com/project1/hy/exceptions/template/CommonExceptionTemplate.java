package com.project1.hy.exceptions.template;

public class CommonExceptionTemplate extends RuntimeException{
  
  private String code;
  private String message;

  public CommonExceptionTemplate(String code, String message) {
    this.code = code;
    this.message = message;
  }

}
