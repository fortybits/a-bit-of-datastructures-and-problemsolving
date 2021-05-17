package edu.bit.datastructures.array;

import java.util.*;

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
        List<Integer> starts = new ArrayList<>();
        for (int i = 0; i < intervals.length; i++) {
            map.put(intervals[i][0], i);
            starts.add(intervals[i][0]);
        }

        Collections.sort(starts); // n logn
        int[] res = new int[intervals.length];
        for (int i = 0; i < intervals.length; i++) {
            int end = intervals[i][1];
            int start = Collections.binarySearch(starts, end);
            if (start < end) {
                res[i] = -1;
            } else {
                res[i] = map.get(start);
            }
        }
        return res;
    }
}