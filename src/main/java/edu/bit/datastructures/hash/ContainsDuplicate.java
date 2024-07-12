package edu.bit.datastructures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an integer array nums and an integer k, return true if there are two distinct indices i and j in the array
 * such that nums[i] == nums[j] and abs(i - j) <= k.
 * <p>
 * <p>
 * 1 <= nums.length <= 10^5
 * -109 <= nums[i] <= 10^9
 * 0 <= k <= 10^5
 */
public class ContainsDuplicate {

    public boolean containsNearbyDuplicate(int[] nums, int k) {
        Map<Integer, Integer> indexLookup = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (indexLookup.containsKey(nums[i])) {
                if ((i - indexLookup.get(nums[i])) <= k) {
                    return true;
                }
            }
            indexLookup.put(nums[i], i);
        }
        return false;
    }
}
