package com.jack.algera.clients;

import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.spi.SudokuRepository;
import java.util.Optional;
import java.util.UUID;

public class SudokuRepositoryImpl implements SudokuRepository {

  @Override
  public Optional<Sudoku> findById(UUID id) {
    return Optional.empty();
  }

  @Override
  public void save(String hash, Sudoku sudoku) {}
}
