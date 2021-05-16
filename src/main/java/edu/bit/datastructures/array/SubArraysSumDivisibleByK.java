package edu.bit.datastructures.array;

/**
 * Given an array nums of integers, return the number of (contiguous, non-empty)
 * sub-arrays that have a sum divisible by k.
 */
public class SubArraysSumDivisibleByK {

    public int countSubArraysDivByK(int[] A, int K) {
        int[] map = new int[K];
        map[0] = 1;
        int count = 0;
        int sum = 0;
        for (int a : A) {
            sum = (sum + a) % K;
            // for negative values, because -1 % 5 = -1, but we need the positive mod 4
            if (sum < 0) {
                sum += K;
            }
            count += map[sum];
            map[sum]++;
        }
        return count;
    }
}