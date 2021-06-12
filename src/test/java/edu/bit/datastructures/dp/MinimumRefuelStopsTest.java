package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumRefuelStopsTest {

    MinimumRefuelStops minimumRefuelStops = new MinimumRefuelStops();

    @Test
    void minRefuelStops() {
        Assertions.assertEquals(2,
                minimumRefuelStops.minRefuelStops(100, 10,
                        new int[][]{{10, 60}, {20, 30}, {30, 30}, {60, 40}}));
        Assertions.assertEquals(-1,
                minimumRefuelStops.minRefuelStops(100, 1,
                        new int[][]{{10, 100}}));
        Assertions.assertEquals(0,
                minimumRefuelStops.minRefuelStops(1, 1,
                        new int[][]{}));
    }
}