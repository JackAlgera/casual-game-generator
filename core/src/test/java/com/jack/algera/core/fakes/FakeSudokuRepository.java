package com.jack.algera.core.fakes;

import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.spi.SudokuRepository;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.UUID;

public class FakeSudokuRepository implements SudokuRepository {

  private static final Map<UUID, Sudoku> map = new HashMap<>();

  @Override
  public Optional<Sudoku> findById(UUID id) {
    return Optional.ofNullable(map.getOrDefault(id, null));
  }

  @Override
  public void save(String id, Sudoku sudoku) {
    map.put(UUID.fromString(id), sudoku);
  }

  public List<Sudoku> findAll() {
    return List.copyOf(map.values());
  }
}
