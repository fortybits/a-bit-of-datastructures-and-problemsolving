package edu.bit.datastructures.array;

/**
 * Given an array of numbers, find GCD of the array elements.
 */
public class GreatestCommonDivisor {

    private int gcd(int a, int b) {
        if (a == 0) {
            return b;
        }
        if (b == 0) {
            return a;
        }
        return a > b ? gcd(a % b, b) : gcd(a, b % a);
    }

    public int findGCD(int[] arr) {
        int result = 0;
        for (int element : arr) {
            result = gcd(result, element);
            if (result == 1) {
                return 1;
            }
        }
        return result;
    }
}