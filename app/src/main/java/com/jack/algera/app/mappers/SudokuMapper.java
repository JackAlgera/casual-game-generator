package com.jack.algera.app.mappers;

import com.jack.algera.app.entities.GenerateSudokuResponse;
import com.jack.algera.app.entities.SudokuValidationRequest;
import com.jack.algera.core.entities.Sudoku;
import java.util.Arrays;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SudokuMapper {

  public static GenerateSudokuResponse toResponse(Sudoku sudoku) {
    var rows =
        Arrays.stream(sudoku.grid())
            .map(
                row ->
                    Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((s1, s2) -> s1 + s2)
                        .orElse(""))
            .filter(row -> !row.isBlank())
            .toList();

    return GenerateSudokuResponse.builder()
        .id(sudoku.id())
        .difficulty(sudoku.difficulty())
        .rows(rows)
        .build();
  }

  public static Sudoku toInstance(SudokuValidationRequest request) {
    var grid =
        request.getGrid().stream()
            .map(row -> row.chars().map(Character::getNumericValue).toArray())
            .toArray(int[][]::new);

    return Sudoku.builder().id(request.getId()).difficulty(null).grid(grid).build();
  }
}
