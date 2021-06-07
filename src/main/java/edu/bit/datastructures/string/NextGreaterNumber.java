package edu.bit.datastructures.string;

import java.util.Arrays;

/**
 * Given a number, find the next higher number which has the exact same
 * set of digits as the original number. For example: given 38276 return 38627
 */
public class NextGreaterNumber {

    // https://stackoverflow.com/questions/9368205/given-a-number-find-the-next-higher-number
    public String findNextGreaterNumber(char[] digits) {
        int i;
        int length = digits.length;

        // Start from the right most digit and find the first digit
        // that is smaller than the digit next to it.
        for (i = length - 1; i > 0; i--) {
            if (digits[i] > digits[i - 1]) {
                break;
            }
        }
        // If no such digit is found, then all digits are in descending order
        // meaning there cannot be a greater number with same set of digits
        if (i == 0) {
            return "Not possible!";
        } else {
            int firstNonIncreasingDigitFromRight = digits[i - 1];
            int indexOfSmallestDigitHigherThanPivot = i;

            // II) Find the smallest digit on right side of (i-1)'th digit that is greater than number[i-1]
            for (int j = i + 1; j < length; j++) {
                if ((digits[j] > firstNonIncreasingDigitFromRight) &&
                        digits[j] < digits[indexOfSmallestDigitHigherThanPivot]) {
                    indexOfSmallestDigitHigherThanPivot = j;
                }
            }

            // III) Swap the above found smallest digit with number[i-1]
            swap(digits, i - 1, indexOfSmallestDigitHigherThanPivot);

            // IV) Sort the digits after (i-1) in ascending order
            Arrays.sort(digits, i, length);
            // or one could simply reverse the digits already in descending order and append the stored digits
        }
        return new String(digits);
    }

    private void swap(char[] ar, int i, int j) {
        char temp = ar[i];
        ar[i] = ar[j];
        ar[j] = temp;
    }
}