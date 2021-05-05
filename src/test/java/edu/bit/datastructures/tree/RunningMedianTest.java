package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RunningMedianTest {

    RunningMedian runningMedian = new RunningMedian();

    @Test
    void medianTracker() {
        Assertions.assertArrayEquals(new double[]{5.0, 10.0, 5.0, 4.0},
                runningMedian.medianTracker(new int[]{5, 15, 1, 3}));

        Assertions.assertArrayEquals(new double[]{5.0, 2.5, 0.0, 2.5, 5.0, 9.0},
                runningMedian.medianTracker(new int[]{5, 0, -7, 13, 45, 60}));

    }
}