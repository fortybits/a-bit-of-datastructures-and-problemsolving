package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeOverlappingIntervalsTest {

    MergeOverlappingIntervals mergeOverlappingIntervals = new MergeOverlappingIntervals();

    @Test
    void testMergeOverlappingIntervals() {
        int[][] expected = new int[][]{{1, 6}, {8, 10}, {15, 18}};
        Assertions.assertArrayEquals(expected,
                mergeOverlappingIntervals.mergeOverlappingIntervals(
                        new int[][]{{1, 3}, {2, 6}, {8, 10}, {15, 18}}));
    }
}