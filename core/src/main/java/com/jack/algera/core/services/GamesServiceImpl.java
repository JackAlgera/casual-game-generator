package com.jack.algera.core.services;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.entities.GameInstance;
import com.jack.algera.core.spi.WordRepository;

public class GamesServiceImpl implements GamesService {

  private WordRepository wordRepository;

  @Override
  public GameInstance getGameInstance(String hash) {
    /* TODO: Implement the logic to retrieve a list of words and generate a cypher for the game instance.
             Make sure a given hash always returns the same game instance.*/
    return null;
  }
}
