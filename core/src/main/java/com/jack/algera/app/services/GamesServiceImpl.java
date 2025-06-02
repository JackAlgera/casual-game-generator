package com.jack.algera.app.services;

import com.jack.algera.app.api.GamesService;
import com.jack.algera.app.entities.GameInstance;
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
}
