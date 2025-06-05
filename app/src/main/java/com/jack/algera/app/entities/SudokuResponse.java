package com.jack.algera.app.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class SudokuResponse {

  @Schema(description = "Unique identifier for the Sudoku game", example = "abc123")
  private String hash;

  @Schema(
      description = "Difficulty level of the Sudoku game",
      defaultValue = "EASY",
      allowableValues = "['EASY', 'MEDIUM', 'HARD', 'EXPERT']")
  private SudokuDifficulty difficulty;

  @Schema(
      description =
          "List of rows in the Sudoku grid, expressed as one-line strings going from left to right of the grid",
      example = "[\"123456789\", \"234567891\", \"345678912\"]")
  private List<String> rows;
}
