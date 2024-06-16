package edu.bit.datastructures.array;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Given an array of intervals where intervals[i] = [starti, endi],
 * merge all overlapping intervals, and return an array of the
 * non-overlapping intervals that cover all the intervals in the input.
 * <a href="https://leetcode.com/problems/merge-intervals/description/">...</a>
 */
public class MergeOverlappingIntervals {

    /**
     * sorted intervals based on the start time
     * final result INT [top]
     * for(each interval)
     * if(INT[i].start in range of INT[i-1])
     * then update INT[i-1] with evaluated upper bound
     * else add the INT[i] to result
     */
    public int[][] mergeOverlappingIntervals(int[][] intervals) {
        if (intervals.length <= 1) {
            return intervals;
        }
        // Sort by ascending starting point
        Arrays.sort(intervals, Comparator.comparingInt(i -> i[0]));

        List<int[]> result = new ArrayList<>();
        int[] newInterval = intervals[0];
        result.add(newInterval);

        for (int[] interval : intervals) {
            if (interval[0] <= newInterval[1]) {
                newInterval[1] = Math.max(newInterval[1], interval[1]);
            } else {
                newInterval = interval;
                result.add(newInterval);
            }
        }
        return result.toArray(int[][]::new);
    }
}