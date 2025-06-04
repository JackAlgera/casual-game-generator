package com.jack.algera.app.services;

import com.jack.algera.app.entities.SudokuDifficulty;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class SudokuGenerationServiceTest implements WithAssertions {

  @Test
  void testGenerateSudokuGame() {
    var game = SudokuGenerationService.generateSudokuGame(SudokuDifficulty.EASY);
    assertThat(game).isNotNull();
  }
}
