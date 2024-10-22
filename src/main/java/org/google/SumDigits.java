package org.google;

import java.util.Stack;

/**
 * Given a string, return the sum of the numbers appearing in the string,
 * ignoring all other characters. A number is a series of 1 or more digit chars in a row.
 * (Note: Character.isDigit(char) tests if a char is one of the chars '0', '1', .. '9'.
 * Integer.parseInt(string) converts a string to an int.)
 * <p>
 * sumNumbers("abc123xyz") → 123
 * sumNumbers("aa11b33") → 44
 * sumNumbers("7 11") → 18
 */
public class SumDigits {

    public int sumNumbers(String str) {
        Stack<Character> characters = new Stack<>();
        int sum = 0;
        for (char ch : str.toCharArray()) {
            if (Character.isDigit(ch)) {
                characters.push(ch);
            } else {
                sum = addValue(characters, sum);
            }
        }
        sum = addValue(characters, sum);

        return sum;
    }

    private static int addValue(Stack<Character> characters, int sum) {
        int multiply = 0;
        int val = 0;
        while (!characters.isEmpty()) {
            char digit = characters.pop();
            val += Integer.parseInt(String.valueOf(digit)) *
                    (int) Math.pow(10, multiply);
            multiply++;
        }
        sum += val;
        return sum;
    }
}
