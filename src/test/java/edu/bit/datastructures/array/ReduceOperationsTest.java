package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ReduceOperationsTest {

    ReduceOperations reduceOperations = new ReduceOperations();

    @Test
    void testReductionOperations() {
        Assertions.assertEquals(3,
                reduceOperations.reductionOperations(new int[]{5, 1, 3}));
        Assertions.assertEquals(0,
                reduceOperations.reductionOperations(new int[]{1, 1, 1}));
        Assertions.assertEquals(4,
                reduceOperations.reductionOperations(new int[]{1, 1, 2, 2, 3}));
    }
}