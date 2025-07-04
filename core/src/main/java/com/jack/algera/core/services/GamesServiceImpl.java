package com.jack.algera.core.services;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.exceptions.InstanceNotFoundException;
import com.jack.algera.core.spi.SudokuRepository;
import java.util.Arrays;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamesServiceImpl implements GamesService {

  private SudokuRepository sudokuRepository;

  @Override
  public boolean validateSudokuGame(Sudoku solutionAttempt) throws InstanceNotFoundException {
    var game =
        sudokuRepository
            .findById(solutionAttempt.id())
            .orElseThrow(
                () ->
                    new InstanceNotFoundException(
                        "Sudoku instance not found for provided ID: " + solutionAttempt.id()));

    return Arrays.deepEquals(game.grid(), solutionAttempt.grid());
  }

  @Override
  public Sudoku generateSudoku(SudokuDifficulty difficulty) {
    var game =
        Sudoku.builder()
            .id(UUID.randomUUID())
            .difficulty(difficulty)
            .grid(SudokuGenerationService.generateSudokuGame(difficulty))
            .build();

    sudokuRepository.save(game.id().toString(), game);

    return game;
  }
}
