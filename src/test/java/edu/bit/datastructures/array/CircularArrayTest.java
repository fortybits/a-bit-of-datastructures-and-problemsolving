package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CircularArrayTest {

    CircularArray circularArray = new CircularArray();

    @Test
    void testCircularTraversal() {
        char[] a = new char[]{'A', 'B', 'C', 'D', 'E', 'F'};
        Assertions.assertEquals("DEFABC", circularArray.circularTraversal(a, 3));
        Assertions.assertEquals("EFABCD", circularArray.circularTraversal(a, 4));
    }
}