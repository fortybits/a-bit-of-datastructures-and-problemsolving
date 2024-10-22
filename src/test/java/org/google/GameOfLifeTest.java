package org.google;

import org.junit.jupiter.api.Test;

class GameOfLifeTest {

    GameOfLife gameOfLife = new GameOfLife();

    @Test
    void testGameOfLife() {
        gameOfLife.gameOfLife(new int[][]{
                {0, 1, 0},
                {0, 0, 1},
                {1, 1, 1},
                {0, 0, 0}
        });
        gameOfLife.gameOfLife(new int[][]{
                {1, 1},
                {1, 0}
        });
    }

}