package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RabbitsInForestTest {

    RabbitsInForest rabbitsInForest = new RabbitsInForest();

    @Test
    void testNumRabbits() {
        Assertions.assertEquals(5,
                rabbitsInForest.numRabbits(new int[]{1, 1, 2}));
        Assertions.assertEquals(11,
                rabbitsInForest.numRabbits(new int[]{10, 10, 10}));
        Assertions.assertEquals(15,
                rabbitsInForest.numRabbits(new int[]{1, 1, 2, 2, 3, 0, 3, 3, 2, 1, 2}));
    }
}