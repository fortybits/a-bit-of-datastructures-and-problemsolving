package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxPerformantTeamTest {

    MaxPerformantTeam maxPerformantTeam = new MaxPerformantTeam();

    @Test
    void testMaxPerformance() {
        Assertions.assertEquals(60,
                maxPerformantTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 2));

        Assertions.assertEquals(68,
                maxPerformantTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 3));

        Assertions.assertEquals(72,
                maxPerformantTeam.maxPerformance(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 4));

        Assertions.assertEquals(56,
                maxPerformantTeam.maxPerformance(3, new int[]{2, 8, 2},
                        new int[]{2, 7, 1}, 2));
    }

    @Test
    void testMaxPerformanceSpaceOpt() {
        Assertions.assertEquals(60,
                maxPerformantTeam.maxPerformanceSpaceOpt(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 2));

        Assertions.assertEquals(68,
                maxPerformantTeam.maxPerformanceSpaceOpt(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 3));

        Assertions.assertEquals(72,
                maxPerformantTeam.maxPerformanceSpaceOpt(6, new int[]{2, 10, 3, 1, 5, 8},
                        new int[]{5, 4, 3, 9, 7, 2}, 4));

        Assertions.assertEquals(56,
                maxPerformantTeam.maxPerformanceSpaceOpt(3, new int[]{2, 8, 2},
                        new int[]{2, 7, 1}, 2));
    }
}