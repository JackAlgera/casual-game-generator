package com.jack.algera.clients;

import com.jack.algera.clients.utils.KeyGenerator;
import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.spi.SudokuRepository;
import java.util.Optional;
import java.util.UUID;
import lombok.AllArgsConstructor;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class SudokuRepositoryImpl implements SudokuRepository {

  private RedisTemplate<String, Sudoku> redisTemplate;

  @Override
  public Optional<Sudoku> findById(UUID id) {
    var key = KeyGenerator.generateSudokuKey(id.toString());
    return Optional.ofNullable(redisTemplate.opsForValue().get(key));
  }

  @Override
  public void save(String id, Sudoku sudoku) {
    var key = KeyGenerator.generateSudokuKey(id);
    redisTemplate.opsForValue().set(key, sudoku);
  }
}
