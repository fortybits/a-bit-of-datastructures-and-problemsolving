package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IntersectionWithDuplicatesTest {

    IntersectionWithDuplicates intersectionWithDuplicates = new IntersectionWithDuplicates();


    @Test
    void testIntersectionWithDuplicates() {
        Assertions.assertArrayEquals(new int[]{2, 2}, intersectionWithDuplicates.intersect(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertArrayEquals(new int[]{9, 4}, intersectionWithDuplicates.intersect(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }

}