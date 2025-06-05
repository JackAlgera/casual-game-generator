package com.jack.algera.app.entities;

import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class SudokuValidationResponse {
  private UUID id;
  private boolean valid;
}
