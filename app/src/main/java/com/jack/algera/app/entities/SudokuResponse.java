package com.jack.algera.app.entities;

import lombok.Builder;

@Builder
public record SudokuResponse(String hash, SudokuGame sudokuGame) {
}
