package com.jack.algera.clients;

import com.jack.algera.core.entities.Sudoku;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.spi.SudokuRepository;
import java.util.UUID;
import org.assertj.core.api.WithAssertions;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * The integration test requires a DB setup, which is not possible with the current CI/CD solution,
 * so just used locally
 */
// @SpringBootTest
class SudokuRepositoryImplITest implements WithAssertions {

  //  @Autowired
  private RedisTemplate<String, Sudoku> redisTemplate;

  //  @Autowired
  private SudokuRepository sudokuRepository;

  //  @BeforeEach
  void setUp() {
    redisTemplate.getConnectionFactory().getConnection().serverCommands().flushAll();
  }

  //  @Test
  void testEntryCorrectlyCreatedAndFetched() {
    // Given an empty Redis database
    var sudoku =
        Sudoku.builder()
            .difficulty(SudokuDifficulty.EXPERT)
            .id(UUID.randomUUID())
            .grid(new int[][] {{1, 1}, {2, 2}})
            .build();
    assertThat(sudokuRepository.findById(sudoku.id())).isEmpty();

    // When saving an entry
    sudokuRepository.save(sudoku.id().toString(), sudoku);

    // Then the entry should be retrievable
    assertThat(sudokuRepository.findById(sudoku.id())).isPresent().get().isEqualTo(sudoku);
  }
}
