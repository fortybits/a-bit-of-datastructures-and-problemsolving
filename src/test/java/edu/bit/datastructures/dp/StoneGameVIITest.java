package edu.bit.datastructures.dp;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class StoneGameVIITest {

    StoneGameVII stoneGameVII = new StoneGameVII();

    @Test
    void testStoneGameVII() {
        Assertions.assertEquals(6,
                stoneGameVII.stoneGameVII(new int[]{5, 3, 1, 4, 2}));
        Assertions.assertEquals(122,
                stoneGameVII.stoneGameVII(new int[]{7, 90, 5, 1, 100, 10, 10, 2}));
    }
}