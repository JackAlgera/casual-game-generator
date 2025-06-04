package com.jack.algera.app.controllers;

import com.jack.algera.app.api.GamesService;
import com.jack.algera.app.entities.GameInstance;
import com.jack.algera.app.entities.SudokuDifficulty;
import com.jack.algera.app.entities.SudokuResponse;
import com.jack.algera.app.helpers.GamePrinterService;
import com.jack.algera.app.mappers.SudokuResponseMapper;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/games")
public class GamesController {

  private GamesService gamesService;
  private GamePrinterService gamePrinterService;

  @GetMapping("/word-guesser/{hash}")
  public ResponseEntity<GameInstance> getWordGuesserGame(@PathVariable String hash) {
    return ResponseEntity.ok(gamesService.getGameInstance(hash));
  }

  @GetMapping("/sudoku/{hash}")
  public ResponseEntity<SudokuResponse> getSudokuGame(@PathVariable String hash) {
    var game = gamesService.getSudokuGame(hash, SudokuDifficulty.EASY);
    return ResponseEntity.ok(SudokuResponseMapper.toResponse(hash, game));
  }

  @GetMapping("/sudoku/{hash}/print")
  public ResponseEntity<String> printSudokuGame(@PathVariable String hash) {
    var sudokuGame = gamesService.getSudokuGame(hash, SudokuDifficulty.EASY);

    return ResponseEntity.ok(gamePrinterService.visualiseGameInstance(sudokuGame));
  }
}
