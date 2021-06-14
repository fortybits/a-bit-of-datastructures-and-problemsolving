package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumUnitsTest {

    MaximumUnitsOnTruck maximumUnits = new MaximumUnitsOnTruck();

    @Test
    void testMaximumUnits() {
        Assertions.assertEquals(8,
                maximumUnits.maximumUnits(new int[][]{{1, 3}, {2, 2}, {3, 1}}, 4));
        Assertions.assertEquals(91,
                maximumUnits.maximumUnits(new int[][]{{5, 10}, {2, 5}, {4, 7}, {3, 9}}, 10));
        Assertions.assertEquals(0,
                maximumUnits.maximumUnits(new int[][]{}, 10));
        Assertions.assertEquals(5,
                maximumUnits.maximumUnits(new int[][]{{1, 2}, {1, 3}}, 12));
    }
}