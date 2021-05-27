package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MedianOfSortedArraysTest {

    MedianOfSortedArrays medianOfSortedArrays = new MedianOfSortedArrays();

    @Test
    void testFindMedianSortedArrays() {
        Assertions.assertEquals(1.0d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{}, new int[]{1}));
        Assertions.assertEquals(2.0d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{2}, new int[]{}));
        Assertions.assertEquals(0.0d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{0, 0}, new int[]{0, 0}));
        Assertions.assertEquals(2.5d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{3, 4}, new int[]{1, 2}));
        Assertions.assertEquals(2.0d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{1, 3}, new int[]{2}));
        Assertions.assertEquals(4.0d,
                medianOfSortedArrays.findMedianSortedArrays(new int[]{2, 5, 6}, new int[]{1, 4}));
    }
}