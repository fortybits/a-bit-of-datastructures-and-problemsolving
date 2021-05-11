package edu.bit.competitive.microsoft;

import edu.bit.problemsolving.competitive.microsoft.IslandCount;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IslandCountTest {

    IslandCount islandCount = new IslandCount();

    @Test
    void countIslandsWithDFS() {
        int[][] M = new int[][]{{1, 1, 0, 0, 0},
                {0, 1, 0, 0, 1},
                {1, 0, 0, 1, 1},
                {0, 0, 0, 0, 0},
                {1, 0, 1, 0, 1}};

        Assertions.assertEquals(5, islandCount.countIslandsWithDFS(M));
    }
}