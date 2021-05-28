package edu.bit.datastructures.array;

/**
 * Given an integer array nums and two integers lower and upper,
 * return the number of range sums that lie in [lower, upper] inclusive.
 * <p>
 * Range sum S(i, j) is defined as the sum of the elements in nums
 * between indices i and j inclusive, where i <= j.
 */
public class CountRangeSum {

    // compute the prefix sum for all ranges starting from i=1 to N
    // for(i:1 to N) => iterate until j to find prefix sum and compare in the range
    // the above would be of O(N^2) time complexity
    public int countRangeSumNaive(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        int ans = 0;
        for (int i = 0; i < n; ++i) {
            for (int j = i + 1; j <= n; ++j) {
                if (sums[j] - sums[i] >= lower && sums[j] - sums[i] <= upper) {
                    ans++;
                }
            }
        }
        return ans;
    }

    // using divide and conquer we can improve our runtime to O(n log n)
    // note: its effectively due to increasing value of the inner loop in countWhileMerge
    // that this tends to be n log n, otherwise the worst case would be O(n^2)
    public int countRangeSumDivideAndConquer(int[] nums, int lower, int upper) {
        int n = nums.length;
        long[] sums = new long[n + 1];
        for (int i = 0; i < n; ++i) {
            sums[i + 1] = sums[i] + nums[i];
        }
        return countWhileMergeSort(sums, 0, n + 1, lower, upper);
    }

    private int countWhileMergeSort(long[] sums, int start, int end, int lower, int upper) {
        if (end - start <= 1) {
            return 0;
        }
        int mid = (start + end) / 2;
        int count = countWhileMergeSort(sums, start, mid, lower, upper)
                + countWhileMergeSort(sums, mid, end, lower, upper);
        int j = mid;
        int k = mid;
        int t = mid;
        long[] cache = new long[end - start];
        for (int i = start, r = 0; i < mid; ++i, ++r) {
            while (k < end && sums[k] - sums[i] < lower) {
                k++;
            }
            while (j < end && sums[j] - sums[i] <= upper) {
                j++;
            }
            while (t < end && sums[t] < sums[i]) {
                cache[r++] = sums[t++];
            }
            cache[r] = sums[i];
            count += j - k;
        }
        System.arraycopy(cache, 0, sums, start, t - start);
        return count;
    }
}