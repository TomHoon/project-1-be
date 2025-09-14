package com.project1.hy.exceptions;

import com.project1.hy.exceptions.template.CommonExceptionTemplate;

public enum FileException {
  NO_FILE("400500", "업로드 파일이 없는뎁쇼?"),
  NO_EXTENSION("400600", "확장자가 없어요 이상한 파일인듯"),
  MAKE_DIRECTORY_ERROR("400400", "디렉토리 생성 중 에러발생(서버)"),
  FILE_SAVE_ERROR("400800", "이미지 저장 중 에러발생(서버)"),
  NO_ALLOWED_EXTENSION("400700", "허락되지 않은 확장자입니다 ");

  CommonExceptionTemplate t;

  private FileException(String code, String message) {
    t = new CommonExceptionTemplate(code, message);
  }

  public CommonExceptionTemplate getException() {
    return this.t;
  }
}
