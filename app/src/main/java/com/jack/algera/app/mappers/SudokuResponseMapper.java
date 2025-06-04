package com.jack.algera.app.mappers;

import com.jack.algera.app.entities.SudokuGame;
import com.jack.algera.app.entities.SudokuResponse;
import java.util.Arrays;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SudokuResponseMapper {

  public static SudokuResponse toResponse(String hash, SudokuGame game) {
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

    return SudokuResponse.builder().hash(hash).difficulty(game.difficulty()).rows(rows).build();
  }
}
