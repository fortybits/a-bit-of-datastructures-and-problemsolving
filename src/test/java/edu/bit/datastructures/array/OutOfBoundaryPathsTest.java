package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class OutOfBoundaryPathsTest {

    OutOfBoundaryPaths outOfBoundaryPaths = new OutOfBoundaryPaths();

    @Test
    void testFindPaths() {
        Assertions.assertEquals(6,
                outOfBoundaryPaths.findPaths(2, 2, 2, 0, 0));
    }

}