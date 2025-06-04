package com.jack.algera.app.spi;

import com.jack.algera.app.entities.SudokuDifficulty;
import com.jack.algera.app.entities.SudokuGame;
import java.util.Optional;

public interface SudokuRepository {

  Optional<SudokuGame> findByHash(String hash, SudokuDifficulty difficulty);

  void save(String hash, SudokuGame sudokuGame);
}
