package com.jack.algera.app.controllers;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.entities.GameInstance;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController("/api/games")
public class GamesController {

  private GamesService gamesService;

  @GetMapping("/word-guesser/{hash}")
  public ResponseEntity<GameInstance> getWordGuesserGame(@PathVariable String hash) {
    return ResponseEntity.ok(gamesService.getGameInstance(hash));
  }
}
