package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeArraysTest {

    MergeArrays mergeArrays = new MergeArrays();

    @Test
    void merge() {
        int[] a = new int[]{1, 3, 5, 7};
        int[] b = new int[]{0, 2, 6, 8, 9};
        mergeArrays.merge(a, b, a.length, b.length);
        Assertions.assertArrayEquals(new int[]{0, 1, 2, 3}, a);
        Assertions.assertArrayEquals(new int[]{5, 6, 7, 8, 9}, b);

        int[] c = new int[]{10, 12};
        int[] d = new int[]{5, 18, 20};
        mergeArrays.merge(c, d, c.length, d.length);
        Assertions.assertArrayEquals(new int[]{5, 10}, c);
        Assertions.assertArrayEquals(new int[]{12, 18, 20}, d);
    }
}