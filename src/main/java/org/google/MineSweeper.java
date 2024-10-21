package org.google;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Minesweeper is a game where the objective is correctly identify the location of all mines in a given grid.
 * You are given a uniform grid of gray squares in the beginning of the game.
 * Each square contains either a mine (indicated by a value of 9), or an empty square.
 * Empty squares have a number indicating the count of mines in the adjacent squares.
 * Empty squares can have counts from zero (no adjacent mines) up to 8 (all adjacent squares are mines).
 * <p>
 * 0  0  0  0  0
 * 0  0  0  0  0
 * 1  1  1  0  0
 * 1  9  1  0  0
 * 1  2  2  1  0
 * 0  1  9  1  0
 * 0  1  1  1  0
 * <p>
 * Gameplay starts with a user un-hiding a square at random.
 * If the square contains a mine, the game ends. If it is a blank, the number of adjacent mines is revealed.
 * <p>
 * Exposing a zero means that there are no adjacent mines, so exposing all adjacent squares is guaranteed safe.
 * As a convenience to the player, the game continues to expose adjacent squares until a non-zero square is reached.
 * <p>
 * Please write functions to construct the playing field given the size and number of mines.
 */
public class MineSweeper {

    class Matrix<T> {
        private List<T> data = new ArrayList<>();
        private int rows = 0;
        private int cols = 0;

        public void resize(int rows, int cols) {
            data.clear();
            data.addAll(Collections.nCopies(rows * cols, null));
            this.rows = rows;
            this.cols = cols;
        }

        public T at(int row, int col) {
            return data.get(row * cols + col);
        }

        public void setAt(int row, int col, T value) {
            data.set(row * cols + col, value);
        }

        public int rows() {
            return rows;
        }

        public int cols() {
            return cols;
        }
    }

    private static final int kMine = 9;

    private static class Spot {
        int value = 0;
        boolean visible = false;
    }

    private Matrix<Spot> matrix = new Matrix<>();

    public MineSweeper(int rows, int cols, int numMines) {
        matrix.resize(rows, cols);
        int sum = rows * cols;
        if (numMines > sum) {
            System.out.println("Too many mines!");
            numMines = sum;
        }

        // Fulfill all spots preparing random shuffle.
        for (int i = 0; i < sum; i++) {
            Spot spot = new Spot();
            spot.value = i < numMines ? kMine : 0;
            matrix.setAt(i / cols, i % cols, spot);
        }

        // Random shuffle.
        for (int i = 0; i < Math.min(numMines, sum - 1); i++) {
            int j = i + (int) (Math.random() * (sum - i));
            Spot temp = matrix.at(i / cols, i % cols);
            matrix.setAt(i / cols, i % cols, matrix.at(j / cols, j % cols));
            matrix.setAt(j / cols, j % cols, temp);
        }

        // Calculate value for each spot.
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (matrix.at(row, col).value != kMine) {
                    continue;
                }
                for (int i = Math.max(0, row - 1); i <= Math.min(rows - 1, row + 1); i++) {
                    for (int j = Math.max(0, col - 1); j <= Math.min(cols - 1, col + 1); j++) {
                        if ((i != row || j != col) && matrix.at(i, j).value != kMine) {
                            matrix.at(i, j).value++;
                        }
                    }
                }
            }
        }
    }

    public boolean onClick(int row, int col) {
        if (row < 0 || row >= matrix.rows() || col < 0 || col >= matrix.cols()) {
            return false;
        }
        if (matrix.at(row, col).visible) {
            return false;
        }
        matrix.at(row, col).visible = true;
        if (matrix.at(row, col).value == kMine) {
            System.out.println("BOOM!\n");
            return true;
        }
        if (matrix.at(row, col).value != 0) {
            return false;
        }
        onClick(row - 1, col);
        onClick(row + 1, col);
        onClick(row, col - 1);
        onClick(row, col + 1);
        return false;
    }

    public void print(boolean showHidden) {
        for (int i = 0; i < matrix.rows(); i++) {
            for (int j = 0; j < matrix.cols(); j++) {
                if (matrix.at(i, j).visible || showHidden) {
                    System.out.print(matrix.at(i, j).value + " ");
                } else {
                    System.out.print(". ");
                }
            }
            System.out.println();
        }
        System.out.println();
    }


    public static void main(String[] args) {
        MineSweeper mineField = new MineSweeper(8, 11, 7);
        mineField.print(true);
        mineField.onClick(5, 1);
        mineField.print(false);
        mineField.onClick(2, 6);
        mineField.print(false);
        mineField.onClick(9, 3);
        mineField.print(false);
        mineField.onClick(0, 0);
        mineField.print(false);
        mineField.onClick(3, 5);
        mineField.print(false);
    }
}