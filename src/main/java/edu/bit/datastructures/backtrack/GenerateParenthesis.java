package edu.bit.datastructures.backtrack;

import java.util.ArrayList;
import java.util.List;

/**
 * Given n pairs of parentheses, write a function to generate all combinations of well-formed parentheses.
 */
public class GenerateParenthesis {

    public List<String> generateParenthesis(int n) {
        List<String> list = new ArrayList<>();
        generateParenthesisHelper("", n, 0, 0, list);
        return list;
    }

    private void generateParenthesisHelper(String currentPrefix, int max, int open, int close, List<String> matches) {
        System.out.println(currentPrefix);
        if ((max * 2) == currentPrefix.length()) {
            matches.add(currentPrefix);
            return;
        }
        if (open < max) {
            generateParenthesisHelper(currentPrefix + "(", max, open + 1, close, matches);
        }
        if (close < open) {
            generateParenthesisHelper(currentPrefix + ")", max, open, close + 1, matches);
        }
    }
}
