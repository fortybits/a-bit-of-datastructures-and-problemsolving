package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RedundantConnectionTest {

    RedundantConnection redundantConnection = new RedundantConnection();

    @Test
    void testFindRedundantConnection() {
        Assertions.assertArrayEquals(new int[]{2, 3},
                redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {1, 3}, {2, 3}}));
        Assertions.assertArrayEquals(new int[]{1, 4},
                redundantConnection.findRedundantConnection(new int[][]{{1, 2}, {2, 3}, {3, 4}, {1, 4}, {1, 5}}));
    }
}