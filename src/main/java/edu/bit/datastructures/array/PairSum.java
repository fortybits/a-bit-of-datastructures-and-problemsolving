package edu.bit.datastructures.array;

import java.util.*;

/**
 * Given an array of integers nums and an integer target, return all pairs such that they add up to target.
 * You can return the answer in any order.
 */
public class PairSum {

    // Time Complexity: O(n) Auxiliary Space: O(n) where n is size of array
    public List<Map.Entry<Integer, Integer>> findPairsWithSum(int[] arr, int sum) {
        List<Map.Entry<Integer, Integer>> pairsWithSum = new ArrayList<>();
        Set<Integer> seen = new HashSet<>();
        for (int j : arr) {
            int temp = sum - j;
            // checking for condition
            if (temp >= 0 && seen.contains(temp)) {
                pairsWithSum.add(Map.entry(j, temp));
            }
            seen.add(j);
        }
        return pairsWithSum;
    }
}
