package org.google;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * According to Wikipedia's article: "The Game of Life, also known simply as Life,
 * is a cellular automaton devised by the British mathematician John Horton Conway in 1970."
 * <p>
 * The board is made up of an m x n grid of cells, where each cell has an initial state:
 * live (represented by a 1) or dead (represented by a 0).
 * Each cell interacts with its eight neighbors (horizontal, vertical, diagonal) using the following four rules
 * (taken from the above Wikipedia article):
 * <p>
 * Any live cell with fewer than two live neighbors dies as if caused by under-population.
 * Any live cell with two or three live neighbors lives on to the next generation.
 * Any live cell with more than three live neighbors dies, as if by over-population.
 * Any dead cell with exactly three live neighbors becomes a live cell, as if by reproduction.
 * The next state is created by applying the above rules simultaneously to every cell in the current state,
 * where births and deaths occur simultaneously. Given the current state of the m x n grid board, return the next state.
 * <p>
 * <p>
 * Follow up:
 * <p>
 * Could you solve it in-place? Remember that the board needs to be updated simultaneously:
 * You cannot update some cells first and then use their updated values to update other cells.
 */
public class GameOfLife {

    public void gameOfLife(int[][] board) {
        int[][] output = new int[board.length][board[0].length];
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                int count = countLiveNeighbors(i, j, board);
                if (board[i][j] == 1) { // live cell
                    if (count == 2 || count == 3) {
                        output[i][j] = 1;
                    } else {
                        output[i][j] = 0;
                    }
                } else { //dead cell
                    if (count == 3) {
                        output[i][j] = 1;
                    } else {
                        output[i][j] = 0;
                    }
                }
            }
        }
        printResult(output);
    }

    private void printResult(int[][] output) {
        System.out.println("[" + Arrays.stream(output)
                .map(row -> "[" + Arrays.stream(row)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(",")) + "]")
                .collect(Collectors.joining(",")) + "]");
    }

    private int[][] dirs = {{-1, -1}, {-1, 0}, {-1, 1}, {0, -1}, {0, 1}, {1, -1}, {1, 0}, {1, 1}};

    private int countLiveNeighbors(int i, int j, int[][] board) {
        int count = 0;
        for (int[] dir : dirs) {
            int adjRow = i + dir[0];
            int adjCol = j + dir[1];
            if (isValid(adjRow, adjCol, board) && board[adjRow][adjCol] == 1) {
                count++;
            }
        }
        return count;
    }

    private boolean isValid(int i, int j, int[][] board) {
        if (i < 0 || i >= board.length) return false;
        if (j < 0 || j >= board[0].length) return false;
        return true;
    }
}
