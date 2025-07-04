package com.jack.algera.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SudokuValidationRequest {

  @Schema(
      description = "Unique UUID for the Sudoku game",
      example = "123e4567-e89b-12d3-a456-426614174000")
  private UUID id;

  @Schema(
      description =
          "List of rows in the Sudoku grid, expressed as one-line strings going from left to right of the grid",
      example =
          "[\"123456789\", \"234567891\", \"345678912\", \"456789123\", \"567891234\", \"678912345\", \"789123456\", \"891234567\", \"912345678\"]")
  private List<String> grid;
}
