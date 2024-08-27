package edu.bit.datastructures.search;

/**
 * Given an array of integers nums containing n + 1 integers where each integer is in the range [1, n] inclusive.
 * <p>
 * There is only one repeated number in nums, return this repeated number.
 * <p>
 * You must solve the problem without modifying the array nums and uses only constant extra space.
 * <p>
 * Constraints:
 * <p>
 * 1 <= n <= 105
 * nums.length == n + 1
 * 1 <= nums[i] <= n
 * All the integers in nums appear only once except for precisely one integer which appears two or more times.
 * <p>
 * Follow up:
 * <p>
 * How can we prove that at least one duplicate number must exist in nums?
 * Can you solve the problem in linear runtime complexity?
 */
public class DuplicateNumber {
    // simpler O(N) approach with extra space O(N) would be to use a set of unique items while iterating over the elements
    // with constant space we can iterate through the elements twice in a nested manner leading to O(N^2) time complexity

    int findDuplicate(int[] nums) {
        int a = 0;
        int b = 0;
        do {
            a = nums[nums[a]];
            b = nums[b];
        } while (a != b);
        b = 0;
        while (a != b) {
            a = nums[a];
            b = nums[b];
        }
        return a;
    }
}
