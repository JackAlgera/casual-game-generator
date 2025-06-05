package com.jack.algera.core.entities;

import java.util.UUID;
import lombok.Builder;

@Builder
public record SudokuGame(UUID id, SudokuDifficulty difficulty, int[][] grid) {}
