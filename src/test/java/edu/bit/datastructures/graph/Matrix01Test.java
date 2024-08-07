package edu.bit.datastructures.graph;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class Matrix01Test {

    Matrix01 matrix01 = new Matrix01();

    @Test
    void test01Matrix() {
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 2, 1}},
                matrix01.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {1, 1, 1}}));
        Assertions.assertArrayEquals(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}},
                matrix01.updateMatrix(new int[][]{{0, 0, 0}, {0, 1, 0}, {0, 0, 0}}));
    }

}