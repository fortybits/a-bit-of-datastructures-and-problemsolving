package edu.bit.datastructures.string;

import java.util.Arrays;
import java.util.stream.Collectors;

/**
 * Given two non-negative integers num1 and num2 represented as strings,
 * return the product of num1 and num2, also represented as a string.
 * Note: You must not use any built-in BigInteger library or convert the inputs to integer directly.
 * Consider the following condition :: 1 <= num1.length, num2.length <= 200
 */
public class MultiplyStrings {

    // Algorithm(length N and M):
    // multiply each digit starting from right of num2 with each digit starting from right of num1 i.e O(M * N)
    // form individual strings (reverse representation) of the product
    // add a leading zero for digits (or multiply by 10) for each character of num2
    // add all these reverse representation to find the overall sum (reversed)  i.e O(M+N)
    // reverse the final representation as a string

    // Algorithm (length N and M):
    // Create an array for position of each digit as we multiply from right to left i.e. O(M*N) with O(M+N) space
    // same as above but the representation would be much simpler than a linked list
    public String multiply(String num1, String num2) {
        int m = num1.length();
        int n = num2.length();
        int[] pos = new int[m + n];

        for (int i = m - 1; i >= 0; i--) {
            for (int j = n - 1; j >= 0; j--) {
                int mul = (num1.charAt(i) - '0') * (num2.charAt(j) - '0');

                int p1 = i + j;
                int p2 = i + j + 1;
                int sum = mul + pos[p2]; // consider the carry from previous computation

                pos[p1] += sum / 10;
                pos[p2] = (sum) % 10;
            }
        }

        String result = Arrays.stream(pos)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());
        return result.length() == 0 ?
                "0" : Integer.valueOf(result).toString(); // remove leading 0s
    }
}