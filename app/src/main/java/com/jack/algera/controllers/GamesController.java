package com.jack.algera.controllers;

import com.jack.algera.core.api.GamesService;
import com.jack.algera.core.entities.SudokuDifficulty;
import com.jack.algera.core.exceptions.InstanceNotFoundException;
import com.jack.algera.entities.GenerateSudokuResponse;
import com.jack.algera.entities.SudokuValidationRequest;
import com.jack.algera.entities.SudokuValidationResponse;
import com.jack.algera.exceptions.InvalidDifficultyException;
import com.jack.algera.mappers.SudokuMapper;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.media.Schema;
import java.util.Optional;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api")
public class GamesController {

  private GamesService gamesService;

  @GetMapping("/sudoku/new")
  public ResponseEntity<GenerateSudokuResponse> generateSudoku(
      @Parameter(
              description = "Difficulty of the Sudoku puzzle",
              schema =
                  @Schema(
                      allowableValues = {"EASY", "MEDIUM", "HARD", "EXPERT"},
                      defaultValue = "EASY"))
          @RequestParam(required = false)
          String difficulty) {
    try {
      var d =
          Optional.ofNullable(difficulty)
              .map(SudokuDifficulty::valueOf)
              .orElse(SudokuDifficulty.EASY);
      var instance = gamesService.generateSudoku(d);
      return ResponseEntity.ok(SudokuMapper.toResponse(instance));
    } catch (IllegalArgumentException e) {
      throw new InvalidDifficultyException();
    }
  }

  @PostMapping("/sudoku/validate")
  public ResponseEntity<SudokuValidationResponse> validateSudoku(
      @RequestBody SudokuValidationRequest request) {
    var solutionAttempt = SudokuMapper.toInstance(request);

    try {
      var validated = gamesService.validateSudokuGame(solutionAttempt);
      return ResponseEntity.ok(
          SudokuValidationResponse.builder().id(solutionAttempt.id()).valid(validated).build());
    } catch (InstanceNotFoundException e) {
      return ResponseEntity.notFound().build();
    }
  }
}
