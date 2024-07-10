package edu.bit.datastructures.uf;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SwimInRisingWaterTest {

    SwimInRisingWater swimInRisingWater = new SwimInRisingWater();

    @Test
    void testSwimInWater() {
        Assertions.assertEquals(3,
                swimInRisingWater.swimInWater(new int[][]{{0, 2}, {1, 3}}));
        Assertions.assertEquals(16,
                swimInRisingWater.swimInWater(new int[][]{{0, 1, 2, 3, 4}, {24, 23, 22, 21, 5},
                        {12, 13, 14, 15, 16}, {11, 17, 18, 19, 20}, {10, 9, 8, 7, 6}}));
    }
}