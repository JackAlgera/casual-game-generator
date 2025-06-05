package com.jack.algera.core;

import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.services.SudokuGenerationService;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class SudokuGenerationServiceTest implements WithAssertions {

  @Test
  void testGenerateSudokuGame() {
    var game = SudokuGenerationService.generateSudokuGame(SudokuDifficulty.EASY);
    assertThat(game).isNotNull();
  }
}
