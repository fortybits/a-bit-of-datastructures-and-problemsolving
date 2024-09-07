package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class ShortestPathWithObstaclesTest {

    ShortestPathWithObstacles shortestPathWithObstacles = new ShortestPathWithObstacles();

    @Test
    void testShortestPath() {
        Assertions.assertEquals(6,
                shortestPathWithObstacles.shortestPath(new int[][]{{0, 0, 0}, {1, 1, 0}, {0, 0, 0}, {0, 1, 1}, {0, 0, 0}}, 1));
        Assertions.assertEquals(-1,
                shortestPathWithObstacles.shortestPath(new int[][]{{0, 1, 1}, {1, 1, 1}, {1, 0, 0}}, 1));
    }

}