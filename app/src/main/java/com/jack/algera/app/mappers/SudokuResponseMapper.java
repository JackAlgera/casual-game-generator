package com.jack.algera.app.mappers;

import com.jack.algera.app.entities.SudokuResponse;
import com.jack.algera.core.entities.SudokuGame;
import java.util.Arrays;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SudokuResponseMapper {

  public static SudokuResponse toResponse(SudokuGame game) {
    var rows =
        Arrays.stream(game.grid())
            .map(
                row ->
                    Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .reduce((s1, s2) -> s1 + s2)
                        .orElse(""))
            .filter(row -> !row.isBlank())
            .toList();

    return SudokuResponse.builder().id(game.id()).difficulty(game.difficulty()).rows(rows).build();
  }
}
