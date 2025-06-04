package com.jack.algera.app.services;

import com.jack.algera.app.api.GamesService;
import com.jack.algera.app.entities.GameInstance;
import com.jack.algera.app.entities.SudokuDifficulty;
import com.jack.algera.app.entities.SudokuGame;
import com.jack.algera.app.spi.SudokuRepository;
import com.jack.algera.app.spi.WordRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamesServiceImpl implements GamesService {

  private WordRepository wordRepository;
  private SudokuRepository sudokuRepository;

  @Override
  public GameInstance getGameInstance(String hash) {
    /* TODO: Implement the logic to retrieve a list of words and generate a cypher for the game instance.
    Make sure a given hash always returns the same game instance.*/
    var test = wordRepository.getWords(5, "some-hash");
    return GameInstance.builder().words(test).build();
  }

  @Override
  public SudokuGame getSudokuGame(String hash, SudokuDifficulty difficulty) {
    return sudokuRepository
        .findByHash(hash, difficulty)
        .orElseGet(
            () ->
                SudokuGame.builder()
                    .grid(SudokuGenerationService.generateSudokuGame(difficulty))
                    .build());
  }
}
