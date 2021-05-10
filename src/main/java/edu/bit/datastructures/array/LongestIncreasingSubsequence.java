package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * Given an integer array nums, return the length of the longest strictly increasing subsequence.
 * <p>
 * A subsequence is a sequence that can be derived from an array by deleting some or
 * no elements without changing the order of the remaining elements.
 * <p>
 * For example, [3,6,2,7] is a subsequence of the array [0,3,1,6,2,2,7].
 */
public class LongestIncreasingSubsequence {
    // When the question is about subsequences/sequences, you shall not think over to generate all of them.

    // If we consider an element X at i, we would have to ensure that we choose another element Y
    // such that array from which we are choosing is arr[i+1,N] and the value Y is greater than X

    // the approach is to initialise each value of the output array with 1
    // update the value of the lis[i] based on the approach that
    // its values is greater or smaller than the previous values to it in the array
    // lis[i] = Math.max(lis[i], lis[j] + 1)
    // once this array is formed after traversing each element, find the max value
    public int lengthOfLongestIncreasingSubsequence(int[] nums) {
        int[] lis = new int[nums.length];
        // Initialize LIS values for all indexes
        for (int i = 0; i < nums.length; i++) {
            lis[i] = 1;
        }

        // Compute optimized LIS values in bottom up manner
        for (int i = 1; i < nums.length; i++) {
            for (int j = 0; j < i; j++) { // compare to all its previous values
                if (nums[i] > nums[j]) {
                    lis[i] = Math.max(lis[i], lis[j] + 1);
                }
            }
        }

        // Pick maximum of all LIS values
        return Arrays.stream(lis)
                .filter(i -> i >= 0)
                .max()
                .orElse(1);
    }

    // a possible optimisation is possible if we consider the inner loop to store the values
    // in a 'sorted array' (maintained by us during the execution) such that
    // if the elements is greater than a last element of the sorted array, I could append to the array
    // else swap the smallest possible value which ensures the order with the current value
    // Collection of integers: 2 6 3 4 1 2 9 5 8
    //0. S = {} - Initialize S to the empty set
    //1. S = {2} - New largest LIS
    //2. S = {2, 6} - New largest LIS
    //3. S = {2, 3} - Changed 6 to 3
    //4. S = {2, 3, 4} - New largest LIS
    //5. S = {1, 3, 4} - Changed 2 to 1
    //6. S = {1, 2, 4} - Changed 3 to 2
    //7. S = {1, 2, 4, 9} - New largest LIS
    //8. S = {1, 2, 4, 5} - Changed 9 to 5
    //9. S = {1, 2, 4, 5, 8} - New largest LIS
    // the length of this array is same as the result desired
    // https://stackoverflow.com/a/2631810/1746118
    public int lengthOfLongestIncreasingSubsequenceOptimised(int[] nums) {
        int[] tails = new int[nums.length];
        int size = 0;
        for (int x : nums) {
            int i = 0;
            int j = size;

            // binary search for the value in the array
            while (i != j) {
                int m = (i + j) / 2; // lower bound ensure the smallest element is replaced
                if (tails[m] < x) {
                    i = m + 1;
                } else {
                    j = m;
                }
            }
            tails[i] = x;

            if (i == size) {
                ++size; // we have appended to the array and the max length could be this at least
            }
        }
        return size;
    }
}