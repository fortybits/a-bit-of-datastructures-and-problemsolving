package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumCostClimbingStairsTest {

    MinimumCostClimbingStairs minimumCostClimbingStairs = new MinimumCostClimbingStairs();

    @Test
    void testMinCostClimbingStairs() {
        Assertions.assertEquals(15,
                minimumCostClimbingStairs.minCostClimbingStairs(new int[]{10, 15, 20}));
        Assertions.assertEquals(6,
                minimumCostClimbingStairs.minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1}));
    }
}