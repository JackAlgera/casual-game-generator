package com.jack.algera.entities;

import com.jack.algera.core.entities.SudokuDifficulty;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@Data
@AllArgsConstructor
public class GenerateSudokuResponse {

  @Schema(
      description = "Unique UUID for the Sudoku game",
      example = "123e4567-e89b-12d3-a456-426614174000")
  private UUID id;

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
