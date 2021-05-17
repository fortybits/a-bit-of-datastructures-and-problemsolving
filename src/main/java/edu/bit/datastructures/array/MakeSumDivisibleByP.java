package edu.bit.datastructures.array;

import java.util.HashMap;
import java.util.Map;

/**
 * Given an array of positive integers nums, remove the smallest subarray (possibly empty)
 * such that the sum of the remaining elements is divisible by p.
 * It is not allowed to remove the whole array.
 * <p>
 * Return the length of the smallest subarray that you need to remove, or -1 if it's impossible.
 * <p>
 * A subarray is defined as a contiguous block of elements in the array.
 */
public class MakeSumDivisibleByP {

    // While we are calculating the running/accumulated sum cur==sum(arr[0...j)),
    // we hope there is some prefix sum prev=sum(arr[0...i])) such that:
    // sum(arr[i...j]) == (cur-prev)%p == sum(arr)%p ==target
    // Therefore, all we need to find is simply (cur-target)%p.
    public int minSubArray(int[] nums, int p) {
        // find the sum of modulo p of the entire array
        // find the minimal sub array size to remove to make the entire sum divisible by p
        int n = nums.length;

        int need = 0;
        for (int a : nums) {
            need = (need + a) % p;
        }
        Map<Integer, Integer> last = new HashMap<>();
        last.put(0, -1);

        int res = n;
        int cur = 0;
        for (int i = 0; i < n; ++i) {
            cur = (cur + nums[i]) % p;
            last.put(cur, i);
            int want = (cur - need + p) % p;
            res = Math.min(res, i - last.getOrDefault(want, -n));
        }
        return res < n ? res : -1;
    }
}