package com.jack.algera.core.services;

import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.fakes.FakeSudokuRepository;
import java.util.Optional;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class GamesServiceImplTest implements WithAssertions {

  private FakeSudokuRepository sudokuRepository;
  private GamesServiceImpl gamesService;

  @BeforeEach
  void setUp() {
    sudokuRepository = new FakeSudokuRepository();
    gamesService = new GamesServiceImpl(sudokuRepository);
  }

  @Test
  void testGenerateSudoku() {
    // Given an empty repository
    assertThat(sudokuRepository.findAll()).isEmpty();

    // When
    var sudoku = gamesService.generateSudoku(SudokuDifficulty.EASY);

    // Then
    assertThat(sudokuRepository.findAll()).isNotEmpty();
    assertThat(sudokuRepository.findById(sudoku.id())).isPresent().isEqualTo(Optional.of(sudoku));
  }

  @Test
  void validateSudokuGame() {
    // Given an empty repository
    var sudoku = gamesService.generateSudoku(SudokuDifficulty.EASY);

    // Then should validate the sudoku game if correct solution is provided
    assertThat(gamesService.validateSudokuGame(sudoku)).isTrue();

    // And should not validate the sudoku game if incorrect solution is provided
    var incorrectSudoku = Sudoku.builder().id(sudoku.id()).grid(new int[][] {}).build();
    assertThat(gamesService.validateSudokuGame(incorrectSudoku)).isFalse();
  }
}
