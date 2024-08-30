package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class BusRoutesTest {

    BusRoutes busRoutes = new BusRoutes();

    @Test
    void testMinBusRoutes() {
        Assertions.assertEquals(2, busRoutes.numBusesToDestination(new int[][]{{1, 2, 7}, {3, 6, 7}}, 1, 6));
        Assertions.assertEquals(-1, busRoutes.numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}}, 15, 12));
        Assertions.assertEquals(1, busRoutes.numBusesToDestination(new int[][]{{7, 12}, {4, 5, 15}, {6}, {15, 19}}, 15, 5));
    }

}