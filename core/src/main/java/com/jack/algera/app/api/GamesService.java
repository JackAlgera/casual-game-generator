package com.jack.algera.app.api;

import com.jack.algera.app.entities.GameInstance;

public interface GamesService {

  GameInstance getGameInstance(String hash);
}
