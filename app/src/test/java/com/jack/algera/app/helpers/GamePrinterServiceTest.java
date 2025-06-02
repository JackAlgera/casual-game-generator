package com.jack.algera.app.helpers;

import com.jack.algera.app.entities.SudokuGame;
import org.assertj.core.api.WithAssertions;
import org.junit.jupiter.api.Test;

class GamePrinterServiceTest implements WithAssertions {

  private final GamePrinterService gamePrinterService = new GamePrinterService();

  @Test
  void testVisualiseGameInstance() {
    // Given
    SudokuGame game = SudokuGame.builder().grid(new int[][] {
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

    // When
    String response = gamePrinterService.visualiseGameInstance(game);

    // Then
    String expectedResponse = "8 6 5 | 2 1 3 | 9 4 7 <br>"
                              + "_ 3 7 | 4 _ 9 | _ 8 _ <br>"
                              + "_ _ 9 | 6 8 7 | 3 _ 5 <br>"
                              + "---------------------<br>"
                              + "1 _ 8 | 9 2 _ | 5 _ _ <br>"
                              + "_ _ 2 | 1 7 _ | 8 6 4 <br>"
                              + "5 7 6 | 8 3 4 | _ 9 1 <br>"
                              + "---------------------<br>"
                              + "9 5 3 | 7 6 _ | 4 1 2 <br>"
                              + "6 8 1 | _ 4 2 | 7 5 9 <br>"
                              + "7 2 4 | _ _ 1 | 6 _ 8 <br>";
    assertThat(response).isEqualTo(expectedResponse);
  }
}