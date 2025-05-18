package com.jack.algera.core.api;

import com.jack.algera.core.entities.GameInstance;

public interface GamesService {

  GameInstance getGameInstance(String hash);
}
