package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * From the set S, find the size of the maximal subset S' such that the sum of any
 * two numbers in S' is not divisible by k.
 * <p>
 * Eg. S = 7, 5, 17, 20, 25, 28, 34, 3, 26
 * k = 4
 * S' = {5, 17, 20, 25, 34}
 */
public class SubSetWithNoPairSumDivision {
    // sum of any two numbers
    // pairSum[N][N] = new
    //    [7,12,24,27,32,35,41,10,33]
    //    [-,5,22,25,30,33,39,8,31]
    //    [-,22,17,25,32,35,41,10,33]

    // Instead we end up creating ann array of modulo with K for all the values.
    // This provides us with ann option of choosing either f[i] and f[K-i] in the subset.
    // we can find out the maximal size considering both the choices such as max(f[i], f[K – i])
    int maximalSubsetPairNotDivisibleByK(int[] arr, int K) {
        // Array for storing frequency of modulo values
        int[] f = new int[K];
        Arrays.fill(f, 0);

        // Fill frequency array with values modulo K
        for (int i = 0; i < arr.length; i++) {
            f[arr[i] % K]++;
        }

        // if K is even, then update f[K/2]
        if (K % 2 == 0) {
            f[K / 2] = Math.min(f[K / 2], 1);
        }

        // Initialize result by minimum of 1 or count of numbers giving remainder 0
        int res = Math.min(f[0], 1);

        // Choose maximum of count of numbers giving remainder i or K-i
        for (int i = 1; i <= K / 2; i++) {
            res += Math.max(f[i], f[K - i]);
        }

        return res;
    }

}