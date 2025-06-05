package com.jack.algera.core.services;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.exceptions.InstanceNotFoundException;
import com.jack.algera.core.spi.SudokuRepository;
import com.jack.algera.core.spi.WordRepository;
import java.util.UUID;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamesServiceImpl implements GamesService {

  private WordRepository wordRepository;
  private SudokuRepository sudokuRepository;

  @Override
  public boolean validateSudokuGame(Sudoku instance) throws InstanceNotFoundException {
    var game =
        sudokuRepository
            .findById(instance.id())
            .orElseThrow(
                () ->
                    new InstanceNotFoundException(
                        "Sudoku instance not found for provided ID: " + instance.id()));

    // TODO: Implement the actual Sudoku validation logic.
    return false;
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
