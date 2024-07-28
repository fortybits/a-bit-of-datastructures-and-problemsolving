package edu.bit.datastructures.stack;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DailyTemperaturesTest {

    DailyTemperatures dailyTemperatures = new DailyTemperatures();

    @Test
    void testDailyTemperatures() {
        Assertions.assertArrayEquals(new int[]{1, 1, 4, 2, 1, 1, 0, 0},
                dailyTemperatures.dailyTemperaturesNaive(new int[]{73, 74, 75, 71, 69, 72, 76, 73}));
        Assertions.assertArrayEquals(new int[]{1, 1, 1, 0},
                dailyTemperatures.dailyTemperaturesNaive(new int[]{30, 40, 50, 60}));
        Assertions.assertArrayEquals(new int[]{1, 1, 0},
                dailyTemperatures.dailyTemperaturesNaive(new int[]{30, 60, 90}));

        Assertions.assertArrayEquals(new int[]{1, 1, 1, 0},
                dailyTemperatures.dailyTemperatures(new int[]{30, 40, 50, 60}));
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 0},
                dailyTemperatures.dailyTemperatures(new int[]{90, 80, 70, 60, 50}));
    }

}