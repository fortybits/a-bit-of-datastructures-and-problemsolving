package edu.bit.datastructures.array;

import edu.bit.datastructures.hash.IntersectionUnionOfArrays;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Set;

class IntersectionUnionOfArraysTest {

    IntersectionUnionOfArrays intersectionUnionOfArrays = new IntersectionUnionOfArrays();

    @Test
    void testMergeOverlappingIntervals() {
        Assertions.assertEquals(Set.of(2), intersectionUnionOfArrays.intersection(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertEquals(Set.of(4, 9), intersectionUnionOfArrays.intersection(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));

        Assertions.assertEquals(Set.of(1, 2), intersectionUnionOfArrays.union(new int[]{1, 2, 2, 1}, new int[]{2, 2}));
        Assertions.assertEquals(Set.of(4, 5, 8, 9), intersectionUnionOfArrays.union(new int[]{4, 9, 5}, new int[]{9, 4, 9, 8, 4}));
    }
}