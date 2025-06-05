package com.jack.algera.app.helpers;

import com.jack.algera.core.entities.SudokuGame;
import org.springframework.stereotype.Service;

@Service
public class GamePrinterService {

  /**
   * Prints the suggested game instance in a human-readable fashion. For example, for Sudoku it
   * prints the following:
   *
   * <p>8 6 5 | 2 1 3 | 9 4 7<br>
   * . 3 7 | 4 . 9 | . 8 .<br>
   * . . 9 | 6 8 7 | 3 . 5<br>
   * - - - - - - - - - - -<br>
   * 1 . 8 | 9 2 . | 5 . .<br>
   * . . 2 | 1 7 . | 8 6 4<br>
   * 5 7 6 | 8 3 4 | . 9 1<br>
   * - - - - - - - - - - -<br>
   * 9 5 3 | 7 6 . | 4 1 2<br>
   * 6 8 1 | . 4 2 | 7 5 9<br>
   * 7 2 4 | . . 1 | 6 . 8<br>
   *
   * @param sudokuGame the Sudoku game instance to be printed
   * @return a human-readable string representation of the Sudoku game instance
   */
  public String visualiseGameInstance(SudokuGame sudokuGame) {
    if (sudokuGame == null || sudokuGame.grid().length == 0) {
      return "What no game found";
    }

    StringBuilder printedGame = new StringBuilder();
    for (int i = 0; i < sudokuGame.grid().length; i++) {
      if (i != 0 && i % 3 == 0) {
        printedGame.append("---------------------\n");
      }

      for (int j = 0; j < sudokuGame.grid()[0].length; j++) {
        if (j != 0 && j % 3 == 0) {
          printedGame.append("| ");
        }

        if (sudokuGame.grid()[i][j] == 0) {
          printedGame.append("_ ");
        } else {
          printedGame.append(sudokuGame.grid()[i][j]).append(" ");
        }
      }
      printedGame.append("\n");
    }

    return printedGame.toString().replace("\n", "<br>");
  }
}
