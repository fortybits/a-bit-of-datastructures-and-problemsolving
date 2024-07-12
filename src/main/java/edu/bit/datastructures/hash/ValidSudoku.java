package edu.bit.datastructures.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
 * <p>
 * Each row must contain the digits 1-9 without repetition.
 * Each column must contain the digits 1-9 without repetition.
 * Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
 * Note:
 * <p>
 * A Sudoku board (partially filled) could be valid but is not necessarily solvable.
 * Only the filled cells need to be validated according to the mentioned rules.
 * <p>
 * <p>
 * board.length == 9
 * board[i].length == 9
 * board[i][j] is a digit 1-9 or '.'.
 */
public class ValidSudoku {

    public boolean isValidSudoku(char[][] board) {
        // one possible but naive way is to iterate multiple times constantly to validate

        // better perform a check based on the grouping by key constructed to represent the 3 rules
        Set<String> structuredKey = new HashSet<>();
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] != '.') {
                    String rowKey = "r" + i + "_" + board[i][j];
                    String colKey = "c" + j + "_" + board[i][j];
                    String subBoxKey = constructSubBoxKey(i, j, board[i][j]);
                    if (!structuredKey.add(rowKey) || !structuredKey.add(colKey)
                            || !structuredKey.add(subBoxKey)) return false;
                }
            }
        }
        return true;
    }

    private String constructSubBoxKey(int i, int j, char c) {
        if (i >= 0 && i < 3) {
            if (j >= 0 && j < 3) {
                return "sb1" + "_" + c;
            }
            if (j >= 3 && j < 6) {
                return "sb2" + "_" + c;
            }
            if (j >= 6 && j < 9) {
                return "sb3" + "_" + c;
            }
        }
        if (i >= 3 && i < 6) {
            if (j >= 0 && j < 3) {
                return "sb4" + "_" + c;
            }
            if (j >= 3 && j < 6) {
                return "sb5" + "_" + c;
            }
            if (j >= 6 && j < 9) {
                return "sb6" + "_" + c;
            }
        }
        if (i >= 6 && i < 9) {
            if (j >= 0 && j < 3) {
                return "sb7" + "_" + c;
            }
            if (j >= 3 && j < 6) {
                return "sb8" + "_" + c;
            }
            if (j >= 6 && j < 9) {
                return "sb9" + "_" + c;
            }
        }
        throw new IllegalArgumentException("");
    }
}