package com.project1.hy.exceptions;

import com.project1.hy.exceptions.template.CommonExceptionTemplate;

public enum BoardException {
  NO_BOARD("40000", "No board found");

  private CommonExceptionTemplate t;

  private BoardException(String code, String message) {
    t = new CommonExceptionTemplate(code, message);
  }

  public CommonExceptionTemplate getException() {
    return t;
  }
}
