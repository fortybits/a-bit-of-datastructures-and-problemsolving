package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class TargetSumTest {

    TargetSum targetSum = new TargetSum();

    @Test
    void testTargetSum() {
        Assertions.assertEquals(5, targetSum.findTargetSumWays(new int[]{1, 1, 1, 1, 1}, 3));
        Assertions.assertEquals(5, targetSum.findTargetSumWaysMemoize(new int[]{1, 1, 1, 1, 1}, 3));
    }

}