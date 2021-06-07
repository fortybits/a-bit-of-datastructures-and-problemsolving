package edu.bit.datastructures.string;

import java.util.List;
import java.util.stream.Stream;

/**
 * You are given a binary string s. You are allowed to perform two types of operations on the string in any sequence:
 * <p>
 * Type-1: Remove the character at the start of the string s and append it to the end of the string.
 * Type-2: Pick any character in s and flip its value, i.e., if its value is '0' it becomes '1' and vice-versa.
 * Return the minimum number of type-2 operations you need to perform such that s becomes alternating.
 * <p>
 * The string is called alternating if no two adjacent characters are equal.
 * <p>
 * For example, the strings "010" and "1010" are alternating, while the string "0100" is not.
 */
public class MinimumFlipsToMakeBinaryAlternating {

    public int minimumFlips(String s) {
        List<Integer> integers = Stream.of(1).toList();
        int n = s.length(); // for comparison window
        char[] complete = s.repeat(2).toCharArray();

        // only two possible results
        char[] firstTarget = new char[complete.length];
        char[] secondTarget = new char[complete.length];
        for (int i = 0; i < complete.length; i++) {
            firstTarget[i] = (i % 2 == 0) ? '0' : '1';
            secondTarget[i] = i % 2 == 0 ? '1' : '0';
        }

        int firstPossibility = 0;
        int secondPossibility = 0;
        int result = Integer.MAX_VALUE;
        for (int i = 0; i < complete.length; i++) {
            if (firstTarget[i] != complete[i]) {
                ++firstPossibility;
            }
            if (secondTarget[i] != complete[i]) {
                ++secondPossibility;
            }
            //the left most element is outside of sliding window, we need to subtract the ans if we do `flip`.
            if (i >= n) {
                if (firstTarget[i - n] != complete[i - n]) {
                    --firstPossibility;
                }
                if (secondTarget[i - n] != complete[i - n]) {
                    --secondPossibility;
                }
            }
            if (i >= n - 1) {
                result = Math.min(firstPossibility, Math.min(secondPossibility, result));
            }
        }
        return result;
    }
}