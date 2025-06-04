package com.jack.algera.app.exceptions;

import org.springframework.http.HttpStatus;

public record ErrorResponse(int status, String message) {

  public static ErrorResponse badRequest(String message) {
    return new ErrorResponse(HttpStatus.BAD_REQUEST.value(), message);
  }
}
