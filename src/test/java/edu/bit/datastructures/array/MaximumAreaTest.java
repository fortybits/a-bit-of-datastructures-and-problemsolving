package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumAreaTest {

    MaximumCakeArea maximumArea = new MaximumCakeArea();

    @Test
    void testMaxCakeArea() {
        Assertions.assertEquals(4,
                maximumArea.maxArea(5, 4, new int[]{1, 2, 4}, new int[]{1, 3}));
        Assertions.assertEquals(6,
                maximumArea.maxArea(5, 4, new int[]{3, 1}, new int[]{1}));
        Assertions.assertEquals(9,
                maximumArea.maxArea(5, 4, new int[]{3}, new int[]{3}));
    }
}