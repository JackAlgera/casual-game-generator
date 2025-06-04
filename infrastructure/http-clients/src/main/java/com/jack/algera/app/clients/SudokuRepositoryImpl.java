package com.jack.algera.app.clients;

import com.jack.algera.app.entities.SudokuDifficulty;
import com.jack.algera.app.entities.SudokuGame;
import com.jack.algera.app.spi.SudokuRepository;
import java.util.Optional;

public class SudokuRepositoryImpl implements SudokuRepository {

  @Override
  public Optional<SudokuGame> findByHash(String hash, SudokuDifficulty difficulty) {
    return Optional.empty();
  }

  @Override
  public void save(String hash, SudokuGame sudokuGame) {}
}
