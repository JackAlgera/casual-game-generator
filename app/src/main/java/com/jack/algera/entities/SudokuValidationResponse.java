package com.jack.algera.entities;

import io.swagger.v3.oas.annotations.media.Schema;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SudokuValidationResponse {

  @Schema(
      description = "Unique UUID for the Sudoku game",
      example = "123e4567-e89b-12d3-a456-426614174000")
  private UUID id;

  @Schema(description = "Indicates whether the provided solution is valid or not", example = "true")
  private boolean valid;
}
