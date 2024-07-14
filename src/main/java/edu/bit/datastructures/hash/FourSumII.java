package edu.bit.datastructures.hash;

import java.util.HashMap;
import java.util.Map;

/**
 * Given four integer arrays nums1, nums2, nums3, and nums4 all of length n,
 * return the number of tuples (i, j, k, l) such that:
 * <p>
 * 0 <= i, j, k, l < n
 * nums1[i] + nums2[j] + nums3[k] + nums4[l] == 0
 * <p>
 * n == nums1.length
 * n == nums2.length
 * n == nums3.length
 * n == nums4.length
 * 1 <= n <= 200
 * -228 <= nums1[i], nums2[i], nums3[i], nums4[i] <= 228
 */
public class FourSumII {

    public int fourSumCount(int[] nums1, int[] nums2, int[] nums3, int[] nums4) {
        Map<Integer, Integer> map = new HashMap<>();

        for (int j : nums3) {
            for (int k : nums4) {
                int sum = j + k;
                map.put(sum, map.getOrDefault(sum, 0) + 1);
            }
        }

        int res = 0;
        for (int j : nums1) {
            for (int k : nums2) {
                res += map.getOrDefault(-1 * (j + k), 0);
                // negative of sum exists after processing the other arrays once
            }
        }

        return res;
    }
}