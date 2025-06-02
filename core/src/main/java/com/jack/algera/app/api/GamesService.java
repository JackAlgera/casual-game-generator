package com.jack.algera.app.api;

import com.jack.algera.app.entities.GameInstance;
import com.jack.algera.app.entities.SudokuDifficulty;
import com.jack.algera.app.entities.SudokuGame;

public interface GamesService {

  GameInstance getGameInstance(String hash);

  SudokuGame getSudokuGame(String hash, SudokuDifficulty difficulty);
}
