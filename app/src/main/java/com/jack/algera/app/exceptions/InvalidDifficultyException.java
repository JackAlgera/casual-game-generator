package com.jack.algera.app.exceptions;

import com.jack.algera.app.entities.SudokuDifficulty;
import java.util.Arrays;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(code = HttpStatus.BAD_REQUEST)
public class InvalidDifficultyException extends RuntimeException {

  public InvalidDifficultyException() {
    super(
        "Invalid Sudoku difficulty provided. Allowed values are: %s"
            .formatted(
                Arrays.stream(SudokuDifficulty.values())
                    .map(SudokuDifficulty::name)
                    .reduce("", (a, b) -> a + ", " + b)));
  }
}
