package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * Count the odd divisors of a number.
 * Given an array, print the total number of such odd divisors for all values.
 */
public class OddDivisorSum {

    public int countTotalOddDivisors(int[] numbers) {
        return Arrays.stream(numbers)
                .map(this::oddDivisorSum)
                .sum();
    }

    private int oddDivisorSum(int number) {
        int oddSum = 1;
        for (int i = 3; i <= number / 2; i += 2) {
            if (number % i == 0) {
                oddSum += i;
            }
        }
        return oddSum;
    }
}