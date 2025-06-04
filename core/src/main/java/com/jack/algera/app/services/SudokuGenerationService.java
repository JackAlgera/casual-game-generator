package com.jack.algera.app.services;

import com.jack.algera.app.entities.SudokuDifficulty;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import lombok.experimental.UtilityClass;

@UtilityClass
public class SudokuGenerationService {

  private static final List<Pair> CELL_OFFSETS =
      List.of(
          Pair.of(0, 0),
          Pair.of(0, 1),
          Pair.of(0, 2),
          Pair.of(1, 0),
          Pair.of(1, 1),
          Pair.of(1, 2),
          Pair.of(2, 0),
          Pair.of(2, 1),
          Pair.of(2, 2));

  private static final List<Pair> CELL_POSITIONS =
      new ArrayList<>(
          List.of(
              Pair.of(0, 0),
              Pair.of(0, 1),
              Pair.of(0, 2),
              Pair.of(0, 3),
              Pair.of(0, 4),
              Pair.of(0, 5),
              Pair.of(0, 6),
              Pair.of(0, 7),
              Pair.of(0, 8),
              Pair.of(1, 0),
              Pair.of(1, 1),
              Pair.of(1, 2),
              Pair.of(1, 3),
              Pair.of(1, 4),
              Pair.of(1, 5),
              Pair.of(1, 6),
              Pair.of(1, 7),
              Pair.of(1, 8),
              Pair.of(2, 0),
              Pair.of(2, 1),
              Pair.of(2, 2),
              Pair.of(2, 3),
              Pair.of(2, 4),
              Pair.of(2, 5),
              Pair.of(2, 6),
              Pair.of(2, 7),
              Pair.of(2, 8),
              Pair.of(3, 0),
              Pair.of(3, 1),
              Pair.of(3, 2),
              Pair.of(3, 3),
              Pair.of(3, 4),
              Pair.of(3, 5),
              Pair.of(3, 6),
              Pair.of(3, 7),
              Pair.of(3, 8),
              Pair.of(4, 0),
              Pair.of(4, 1),
              Pair.of(4, 2),
              Pair.of(4, 3),
              Pair.of(4, 4),
              Pair.of(4, 5),
              Pair.of(4, 6),
              Pair.of(4, 7),
              Pair.of(4, 8),
              Pair.of(5, 0),
              Pair.of(5, 1),
              Pair.of(5, 2),
              Pair.of(5, 3),
              Pair.of(5, 4),
              Pair.of(5, 5),
              Pair.of(5, 6),
              Pair.of(5, 7),
              Pair.of(5, 8),
              Pair.of(6, 0),
              Pair.of(6, 1),
              Pair.of(6, 2),
              Pair.of(6, 3),
              Pair.of(6, 4),
              Pair.of(6, 5),
              Pair.of(6, 6),
              Pair.of(6, 7),
              Pair.of(6, 8),
              Pair.of(7, 0),
              Pair.of(7, 1),
              Pair.of(7, 2),
              Pair.of(7, 3),
              Pair.of(7, 4),
              Pair.of(7, 5),
              Pair.of(7, 6),
              Pair.of(7, 7),
              Pair.of(7, 8),
              Pair.of(8, 0),
              Pair.of(8, 1),
              Pair.of(8, 2),
              Pair.of(8, 3),
              Pair.of(8, 4),
              Pair.of(8, 5),
              Pair.of(8, 6),
              Pair.of(8, 7),
              Pair.of(8, 8)));

  public static int[][] generateSudokuGame(SudokuDifficulty difficulty) {
    int[][] grid = new int[9][9];

    // Fill diagonal boxes
    fillDiagonalBoxes(grid);

    // Fill remaining cells in grid
    fillRemainingCells(grid, 0, 0);

    // Remove some digits depending on the difficulty level
    removeDigits(grid, difficulty);

    return grid;
  }

  /**
   * Removes digits from the Sudoku grid based on the specified difficulty level. Very basic
   * implementation that does not yet take the difficulty into account, but only removes a fixed
   * number of cells.
   *
   * @param difficulty the difficulty level of the Sudoku game
   */
  private static void removeDigits(int[][] grid, SudokuDifficulty difficulty) {
    int cellsToRemove =
        switch (difficulty) {
          case EASY -> 19;
          case MEDIUM -> 28;
          case HARD -> 37;
          case EXPERT -> 46;
        };

    Collections.shuffle(CELL_POSITIONS);

    for (int k = 0; k < cellsToRemove; k++) {
      Pair position = CELL_POSITIONS.get(k);
      grid[position.i()][position.j()] = 0;
    }
  }

  /** Fills all 3x3 diagonal grid boxes with random values from 1 to 9. */
  private static void fillDiagonalBoxes(int[][] grid) {
    List<Integer> values = new ArrayList<>(List.of(0, 1, 2, 3, 4, 5, 6, 7, 8));

    for (int i = 0; i < 9; i += 3) {
      // Shuffle the cell offsets and values to ensure randomness
      Collections.shuffle(values);

      for (int k = 1; k <= 9; k++) {
        Pair offset = CELL_OFFSETS.get(values.get(k - 1));
        grid[i + offset.i()][i + offset.j()] = k;
      }
    }
  }

  /** Fills remaining empty cells of the grid with valid Sudoku values recursively. */
  private static boolean fillRemainingCells(int[][] grid, int i, int j) {
    // If we have filled all rows, return true
    if (i == 9) {
      return true;
    }

    // Move to the next row if we reach the end of the current row
    if (j == 9) {
      return fillRemainingCells(grid, i + 1, 0);
    }

    // Skip if already filled
    if (grid[i][j] != 0) {
      return fillRemainingCells(grid, i, j + 1);
    }

    for (int k = 1; k <= 9; k++) {
      if (isValidCell(grid, i, j, k)) {
        // Try placing the value k in the cell
        grid[i][j] = k;

        // Recursively fill the next cells
        if (fillRemainingCells(grid, i, j + 1)) {
          return true; // If successful, return true
        }

        // Backtrack if not successful
        grid[i][j] = 0;
      }
    }

    return false; // If no valid number can be placed, return false
  }

  private boolean isValidCell(int[][] grid, int i, int j, int value) {
    // Check if value is not in the current row
    for (int k = 0; k < 9; k++) {
      if (grid[i][k] == value) {
        return false;
      }
    }

    // Check if value is not in the current column
    for (int k = 0; k < 9; k++) {
      if (grid[k][j] == value) {
        return false;
      }
    }

    // Check if value is not in the current 3x3 box
    int boxIStart = i - i % 3;
    int boxJStart = j - j % 3;
    for (int row = boxIStart; row < boxIStart + 3; row++) {
      for (int col = boxJStart; col < boxJStart + 3; col++) {
        if (grid[row][col] == value) {
          return false;
        }
      }
    }

    return true;
  }

  private record Pair(int i, int j) {
    static Pair of(int i, int j) {
      return new Pair(i, j);
    }
  }
}
