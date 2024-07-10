package edu.bit.datastructures.hash;

import java.util.HashSet;
import java.util.Set;

/**
 * Write an algorithm to determine if a number n is happy.
 * <p>
 * A happy number is a number defined by the following process:
 * <p>
 * Starting with any positive integer, replace the number by the sum of the squares of its digits.
 * Repeat the process until the number equals 1 (where it will stay), or it loops endlessly in a cycle which does not include 1.
 * Those numbers for which this process ends in 1 are happy.
 * Return true if n is a happy number, and false if not.
 * <p>
 * Example 1:
 * <p>
 * Input: n = 19
 * Output: true
 * Explanation:
 * 1^2 + 9^2 = 82
 * 8^2 + 2^2 = 68
 * 6^2 + 8^2 = 100
 * 1^2 + 0^2 + 0^2 = 1
 * <p>
 * Example 2:
 * <p>
 * Input: n = 2
 * Output: false
 */
public class HappyNumber {

    public boolean isHappy(int n) {
        Set<Integer> sum = new HashSet<>();
        int value = n;
        while (value != 1 && !sum.contains(value)) {
            sum.add(value);
            value = sumOfSquareOfDigits(value);
        }
        return value == 1;
    }

    private int sumOfSquareOfDigits(int n) {
        int sum = 0;
        String stringNumber = Integer.toString(n);
        for (int i = 0; i < stringNumber.length(); i++) {
            int dig = stringNumber.charAt(i) - '0';
            sum += (dig * dig);
        }
        return sum;
    }

}