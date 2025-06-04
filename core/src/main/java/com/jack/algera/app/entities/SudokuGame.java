package com.jack.algera.app.entities;

import lombok.Builder;

@Builder
public record SudokuGame(SudokuDifficulty difficulty, int[][] grid) {}
