package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanPartitionTest {

    CanPartition canPartition = new CanPartition();

    @Test
    void canPartition() {
        Assertions.assertTrue(canPartition.canPartition(new int[]{1, 5, 11, 5}));
        Assertions.assertFalse(canPartition.canPartition(new int[]{1, 2, 3, 5}));
    }

    @Test
    void canPartitionOptimiseSpace() {
        Assertions.assertTrue(canPartition.canPartitionOptimiseSpace(new int[]{1, 5, 11, 5}));
        Assertions.assertFalse(canPartition.canPartition(new int[]{1, 2, 3, 5}));
    }
}