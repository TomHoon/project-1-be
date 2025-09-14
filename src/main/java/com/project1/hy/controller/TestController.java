package com.project1.hy.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class TestController {
  
  @GetMapping("/test1")
  public String test() {
    return "공통응답테스트";
  }
}
