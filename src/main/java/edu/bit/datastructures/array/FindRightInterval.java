package edu.bit.datastructures.array;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * You are given an array of intervals, where intervals[i] = [starti, endi] and each starti is unique.
 * <p>
 * The right interval for an interval i is an interval j such that startj >= endi and startj is minimized.
 * <p>
 * Return an array of right interval indices for each interval i.
 * If no right interval exists for interval i, then put -1 at index i.
 */
public class FindRightInterval {

    public int[] findRightInterval(int[][] intervals) {
        Map<Integer, Integer> map = new HashMap<>();
        int[] starts = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
            starts[i] = intervals[i][0];
        }
        Arrays.sort(starts); // O(n logn)

        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) { //  O(n)
            int l = 0;
            int r = intervals.length - 1;
            boolean found = false;              //to see if result was found
            int min = -1;
            int ep = intervals[i][1];           //ep = endpoint
            while (l <= r) {                     //binarySearch on arr of start points
                int mid = (l + ((r - l) / 2));
                if (starts[mid] >= ep) {
                    min = starts[mid];
                    found = true;
                    r = mid - 1;
                } else {
                    l = mid + 1;
                }
            }
            res[i] = found ? map.get(min) : -1;
        }
        return res;
    }
}