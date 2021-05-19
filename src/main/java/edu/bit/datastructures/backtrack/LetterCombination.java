package edu.bit.datastructures.backtrack;

import java.util.*;
import java.util.function.Function;

/**
 * Given a string containing digits from 2-9 inclusive, return all possible letter combinations
 * that the number could represent. Return the answer in any order.
 * <p>
 * A mapping of digit to letters (just like on the telephone buttons) is given below.
 * Note that 1 does not map to any letters.
 */
public class LetterCombination {

    private static final String[] KEYS = {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};

    // create all arrays for each of the numbers and characters that can be represented
    // for each character in first digit array, iterate for all character in next digit and so on
    // update a list of words with these combinations of strings
    public List<String> letterCombinations(String digits) {
        List<String> words = new LinkedList<>();
        if (digits.length() == 0) {
            return words;
        }
        // call void method here that updates the list with a prefix and uses the current digit offset

        combination("", digits, 0, words);
        return words;
    }

    private void combination(String prefix, String digits, int offset, List<String> words) {
        if (offset >= digits.length()) {
            words.add(prefix);
            return;
        }
        String letters = KEYS[(digits.charAt(offset) - '0')];
        for (int i = 0; i < letters.length(); i++) {
            combination(prefix + letters.charAt(i), digits, offset + 1, words);
        }
    }

    public List<String> letterCombinationsWithFIFO(String digits) {
        LinkedList<String> ans = new LinkedList<>();
        if (digits.isEmpty()) {
            return ans;
        }
        String[] mapping = new String[]{"0", "1", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        ans.add("");
        for (int i = 0; i < digits.length(); i++) {
            int x = digits.charAt(i) - '0';
            // only peek those in the queue which has the length equal to current index
            while (ans.peek().length() == i) {
                String t = ans.remove();
                for (char s : mapping[x].toCharArray()) {
                    ans.add(t + s);
                }
            }
        }
        return ans;
    }
}