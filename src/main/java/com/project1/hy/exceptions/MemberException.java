package com.project1.hy.exceptions;

import com.project1.hy.exceptions.template.MemberExceptionTemplate;

public enum MemberException {
  NOT_FOUND("400404", "그런멤버 없습니다;;"),
  WRONG_PASSWORD("200403", "비밀번호 이게 맞음?;;"),
  EMPTY_PASSWORD("200401", "비밀번호 비어있음요.."),
  ALREADY_EXIST("200301", "이미 존재하는 회원입니다만?"),
  NOT_EXIST_MEMBER("200402", "그런 회원 없는데요");

  private MemberExceptionTemplate t;

  MemberException(String code, String message) {
    this.t = new MemberExceptionTemplate(code, message);
  }

  public MemberExceptionTemplate getException() {
    return this.t;
  }
}
