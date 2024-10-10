package edu.bit.datastructures.array;

/**
 * Given a binary array nums, return the maximum number of consecutive 1's in the array.
 * Example 1:
 * <p>
 * Input: nums = [1,1,0,1,1,1]
 * Output: 3
 */
public class MaxConsecutiveOnes {

    public int findMaxConsecutiveOnes(int[] nums) {
        int maxConsec = 0;
        int currentConsec = 0;
        for (int num : nums) {
            if (num == 1) {
                currentConsec++;
            } else {
                maxConsec = Math.max(maxConsec, currentConsec);
                currentConsec = 0;
            }
        }
        return Math.max(currentConsec, maxConsec);
    }

}
