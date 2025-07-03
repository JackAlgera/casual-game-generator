package com.jack.algera.entities;

import java.util.List;
import java.util.UUID;
import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class SudokuValidationRequest {
  private UUID id;
  private List<String> grid;
}
