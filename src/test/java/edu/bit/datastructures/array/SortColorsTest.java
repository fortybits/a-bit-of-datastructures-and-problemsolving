package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SortColorsTest {

    SortColors sortColors = new SortColors();

    @Test
    void testSortingColors() {
        Assertions.assertArrayEquals(new int[]{0, 0, 0, 0, 1, 1, 1, 2, 2, 2},
                sortColors.sortColors(new int[]{1, 1, 0, 0, 2, 2, 0, 1, 0, 2}, 10));
    }

}