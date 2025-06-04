package com.jack.algera.app.entities;

import java.util.List;
import lombok.Builder;

@Builder
public record SudokuResponse(String hash, List<String> rows) {
}
