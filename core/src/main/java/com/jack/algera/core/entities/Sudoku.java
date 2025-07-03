package com.jack.algera.core.entities;

import java.util.Arrays;
import java.util.Objects;
import java.util.UUID;
import lombok.Builder;

@Builder
public record Sudoku(UUID id, SudokuDifficulty difficulty, int[][] grid) {
  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (!(o instanceof Sudoku other)) return false;
    return Objects.equals(id, other.id)
        && difficulty == other.difficulty
        && Arrays.deepEquals(grid, other.grid);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, difficulty, Arrays.deepHashCode(grid));
  }
}
