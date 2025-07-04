package com.jack.algera.core.api;

import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.exceptions.InstanceNotFoundException;

public interface GamesService {

  boolean validateSudokuGame(Sudoku solutionAttempt) throws InstanceNotFoundException;

  Sudoku generateSudoku(SudokuDifficulty difficulty);
}
