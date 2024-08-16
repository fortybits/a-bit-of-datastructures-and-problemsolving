package edu.bit.datastructures.search;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FindMinimumInRotatedArrayTest {

    FindMinimumInRotatedArray findMinimumInRotatedArray = new FindMinimumInRotatedArray();

    @Test
    void testFindMinimumInRotatedArray() {
        Assertions.assertEquals(0, findMinimumInRotatedArray.findMin(new int[]{4, 5, 6, 7, 0, 1, 2}));
        Assertions.assertEquals(11, findMinimumInRotatedArray.findMin(new int[]{11, 13, 15, 17}));
        Assertions.assertEquals(1, findMinimumInRotatedArray.findMin(new int[]{3, 1, 2}));
    }
}