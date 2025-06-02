package com.jack.algera.app.services;

import com.jack.algera.app.api.GamesService;
import com.jack.algera.app.entities.GameInstance;
import com.jack.algera.app.entities.SudokuGame;
import com.jack.algera.app.spi.WordRepository;
import lombok.AllArgsConstructor;

@AllArgsConstructor
public class GamesServiceImpl implements GamesService {

  private WordRepository wordRepository;

  @Override
  public GameInstance getGameInstance(String hash) {
    /* TODO: Implement the logic to retrieve a list of words and generate a cypher for the game instance.
             Make sure a given hash always returns the same game instance.*/
    var test = wordRepository.getWords(5, "some-hash");
    return GameInstance.builder().words(test).build();
  }

  @Override
  public SudokuGame getSudokuGame(String hash) {
    return SudokuGame.builder().grid(new int[][] {
                                        new int[]{8, 6, 5, 2, 1, 3, 9, 4, 7},
                                        new int[]{0, 3, 7, 4, 0, 9, 0, 8, 0},
                                        new int[]{0, 0, 9, 6, 8, 7, 3, 0, 5},
                                        new int[]{1, 0, 8, 9, 2, 0, 5, 0, 0},
                                        new int[]{0, 0, 2, 1, 7, 0, 8, 6, 4},
                                        new int[]{5, 7, 6, 8, 3, 4, 0, 9, 1},
                                        new int[]{9, 5, 3, 7, 6, 0, 4, 1, 2},
                                        new int[]{6, 8, 1, 0, 4, 2, 7, 5, 9},
                                        new int[]{7, 2, 4, 0, 0, 1, 6, 0, 8}})
                                .build();
  }
}
