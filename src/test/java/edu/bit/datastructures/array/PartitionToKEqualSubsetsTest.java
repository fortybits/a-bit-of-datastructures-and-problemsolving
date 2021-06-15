package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PartitionToKEqualSubsetsTest {

    PartitionToKEqualSubsets partitionToKEqualSubsets = new PartitionToKEqualSubsets();

    @Test
    void partitionIntoEqualSubsets() {
        Assertions.assertTrue(partitionToKEqualSubsets.partitionIntoEqualSubsets(new int[]{4, 3, 2, 3, 5, 2, 1}, 4));
        Assertions.assertFalse(partitionToKEqualSubsets.partitionIntoEqualSubsets(new int[]{1, 2, 3, 4}, 3));
    }
}