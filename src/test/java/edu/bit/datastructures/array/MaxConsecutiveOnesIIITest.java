package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxConsecutiveOnesIIITest {

    MaxConsecutiveOnesIII maxConsecutiveOnesIII = new MaxConsecutiveOnesIII();

    @Test
    void testLongestOnes() {
        Assertions.assertEquals(6,
                maxConsecutiveOnesIII.longestOnes(new int[]{1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 0}, 2));
        Assertions.assertEquals(10,
                maxConsecutiveOnesIII.longestOnes(new int[]{0, 0, 1, 1, 0, 0, 1, 1, 1, 0, 1, 1, 0, 0, 0, 1, 1, 1, 1}, 3));
    }
}