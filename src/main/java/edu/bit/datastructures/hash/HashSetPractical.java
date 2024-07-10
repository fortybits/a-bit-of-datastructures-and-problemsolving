package edu.bit.datastructures.hash;

import java.util.HashSet;
import java.util.Set;


public class HashSetPractical {

    /**
     * Given an integer array nums, return true if any value appears at least twice in the array, and return false if every element is distinct.
     *
     * @param nums 1 <= nums.length <= 10^5
     *             -10^9 <= nums[i] <= 10^9
     * @return
     */
    public boolean containsDuplicate(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
            } else {
                return true;
            }
        }
        return false;
    }

    /**
     * Given a non-empty array of integers nums, every element appears twice except for one.
     * Find that single one.
     * <p>
     * You must implement a solution with a linear runtime complexity and use only constant extra space.
     * <p>
     * Each element in the array appears twice except for one element which appears only once.
     *
     * @param nums 1 <= nums.length <= 3 * 10^4
     *             -3 * 10^4 <= nums[i] <= 3 * 10^4
     * @return
     */
    public int singleNumber(int[] nums) {
        int uniqueSum = 0;
        int actualSum = 0;
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums) {
            if (!hashSet.contains(num)) {
                hashSet.add(num);
                uniqueSum += num;
            } else {
                hashSet.remove(num);
            }
            actualSum += num;
        }
        return (2 * uniqueSum) - actualSum;
    }
}