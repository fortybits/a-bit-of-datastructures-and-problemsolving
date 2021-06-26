package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CountNumberSmallerThanSelfTest {

    CountNumberSmallerThanSelf smallerThanSelf = new CountNumberSmallerThanSelf();

    @Test
    void testCountSmaller() {
        Assertions.assertEquals(List.of(2, 1, 1, 0),
                smallerThanSelf.countSmaller(new int[]{5, 2, 6, 1}));

        Assertions.assertEquals(List.of(0),
                smallerThanSelf.countSmaller(new int[]{-1}));

        Assertions.assertEquals(List.of(0, 0),
                smallerThanSelf.countSmaller(new int[]{-1, -1}));
    }
}