package com.jack.algera.clients.utils;

import static org.junit.jupiter.api.Assertions.*;

import java.util.UUID;
import java.util.stream.Stream;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

class KeyGeneratorTest implements WithAssertions {

  static Stream<Arguments> generateSudokuKey_nominalCase() {
    return Stream.of(
        Arguments.of("123", "sudoku:123"),
        Arguments.of("", "sudoku:"),
        Arguments.of(
            UUID.fromString("123e4567-e89b-12d3-a456-426614174000").toString(),
            "sudoku:123e4567-e89b-12d3-a456-426614174000"),
        Arguments.of("abc", "sudoku:abc"));
  }

  @ParameterizedTest
  @MethodSource
  void generateSudokuKey_nominalCase(String id, String expectedKey) {
    // when
    var key = KeyGenerator.generateSudokuKey(id);

    // then
    assertThat(key).isEqualTo(expectedKey);
  }
}
