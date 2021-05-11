package edu.bit.problemsolving.competitive.leet.weekly.mayone;

/**
 * You are given two non-increasing 0-indexed integer arrays nums1and nums2
 * <p>
 * A pair of indices (i, j), where 0 <= i < nums1.length and 0 <= j < nums2.length,
 * is valid if both i <= j and nums1[i] <= nums2[j]. The distance of the pair is j - i
 * <p>
 * Return the maximum distance of any valid pair (i, j). If there are no valid pairs, return 0.
 * <p>
 * An array arr is non-increasing if arr[i-1] >= arr[i] for every 1 <= i < arr.length.
 */
public class MaximumDistanceBetweenPairOfValues {

    public int maxDistance(int[] nums1, int[] nums2) {
        int dist = 0;
        for (int k = 0; k < nums1.length; k++) {
            for (int l = k + 1; l < nums2.length; l++) {
                if (nums1[k] <= nums2[l]) {
                    dist = Math.max(dist, l - k);
                } else {
                    break;
                }
            }
        }
        return dist;
    }

    public int maxDistanceOpt(int[] nums1, int[] nums2) {
        int i = 0;
        int j = nums2.length;
        int dist = 0;
        while (i < nums1.length && j >= i) {
            if (nums1[i] >= nums2[j]) {
                j--;
            }
            if (i > j) {
                j++;
            } else {
                dist = Math.max(dist, (j - i));
                i++;
            }
        }
        return dist;
    }
}