package com.jack.algera.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(InvalidDifficultyException.class)
  public ResponseEntity<ErrorResponse> handleBadRequestException(
      InvalidDifficultyException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST)
        .body(ErrorResponse.badRequest(exception.getMessage()));
  }
}
