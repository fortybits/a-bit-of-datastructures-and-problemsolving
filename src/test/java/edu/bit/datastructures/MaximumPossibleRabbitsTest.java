package edu.bit.datastructures;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumPossibleRabbitsTest {

    MinimalPossibleRabbits minimalPossibleRabbits = new MinimalPossibleRabbits();

    @Test
    void testMinimalRabbits() {
        Assertions.assertEquals(5,
                minimalPossibleRabbits.minimalRabbits(new int[]{1, 1, 2}));
        Assertions.assertEquals(15,
                minimalPossibleRabbits.minimalRabbits(new int[]{1, 1, 2, 2, 3, 0, 3, 3, 2, 1, 2}));
    }
}