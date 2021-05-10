package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumSwapToSortAnArrayTest {

    MinimumSwapToSortAnArray minimumSwapToSortAnArray = new MinimumSwapToSortAnArray();

    @Test
    void testMinimumSwapsToSortArray() {
        Assertions.assertEquals(2,
                minimumSwapToSortAnArray.minSwaps(new int[]{4, 3, 2, 1}));
        Assertions.assertEquals(2,
                minimumSwapToSortAnArray.minSwaps(new int[]{1, 5, 4, 3, 2}));
    }

}