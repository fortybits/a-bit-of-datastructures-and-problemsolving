package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MountainArrayTest {

    MountainArray mountainArray = new MountainArray();

    @Test
    void testMountainArray() {
        Assertions.assertFalse(mountainArray.validMountainArray(new int[]{2, 1}));
        Assertions.assertTrue(mountainArray.validMountainArray(new int[]{0, 1, 4, 5, 3, 2, 1}));
        Assertions.assertFalse(mountainArray.validMountainArray(new int[]{9, 8, 7, 6, 5, 4, 3, 2, 1, 0}));
    }

}