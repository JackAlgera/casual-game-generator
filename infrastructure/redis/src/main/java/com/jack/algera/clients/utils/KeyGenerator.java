package com.jack.algera.clients.utils;

import lombok.experimental.UtilityClass;

@UtilityClass
public class KeyGenerator {

  public String generateSudokuKey(String id) {
    return "sudoku:%s".formatted(id);
  }
}
