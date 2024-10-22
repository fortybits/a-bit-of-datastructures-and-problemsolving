package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * Given a non-empty array, return true if there is a place to split the array
 * so that the sum of the numbers on one side is equal to the sum of the numbers on the other side.
 * canBalance([1, 1, 1, 2, 1]) → true
 * canBalance([2, 1, 1, 2, 1]) → false
 * canBalance([10, 10]) → true
 * canBalance([10, 10, 10]) → false
 */
public class CanBalance {

    // would these numbers always be positive?
    // prefix sum with overall value and finding the half in the array can possibly work here
    public boolean canBalance(int[] nums) {
        if (nums.length <= 1) return false;
        int[] sum = new int[nums.length];
        Arrays.fill(sum, 0);
        sum[0] = nums[0];
        for (int i = 1; i < nums.length; i++) {
            sum[i] = nums[i] + sum[i - 1];
        }
        int total = sum[nums.length - 1];
        if (total % 2 == 1) return false;
        return Arrays.binarySearch(sum, total / 2) >= 0;
    }

}