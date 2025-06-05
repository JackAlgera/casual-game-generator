package com.jack.algera.core.entities;

import java.util.UUID;
import lombok.Builder;

@Builder
public record Sudoku(UUID id, SudokuDifficulty difficulty, int[][] grid) {}
