package com.jack.algera.core.spi;

import com.jack.algera.core.entities.Sudoku;
import java.util.Optional;
import java.util.UUID;

public interface SudokuRepository {

  Optional<Sudoku> findById(UUID id);

  void save(String id, Sudoku sudoku);
}
