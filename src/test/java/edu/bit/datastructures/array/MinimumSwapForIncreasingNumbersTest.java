package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumSwapForIncreasingNumbersTest {

    MinimumSwapForIncreasingNumbersInTwoArrays minimumSwapForIncreasingNumbers = new MinimumSwapForIncreasingNumbersInTwoArrays();

    @Test
    void testMinSwap() {
        Assertions.assertEquals(1,
                minimumSwapForIncreasingNumbers.minSwap(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));

        Assertions.assertEquals(1,
                minimumSwapForIncreasingNumbers.minSwap(new int[]{1, 3, 3, 5, 4}, new int[]{1, 2, 2, 3, 7}));
    }

    @Test
    void testMinSwapOptimisedSpace() {
        Assertions.assertEquals(1,
                minimumSwapForIncreasingNumbers.minSwapOptimisedSpace(new int[]{1, 3, 5, 4}, new int[]{1, 2, 3, 7}));

        Assertions.assertEquals(1,
                minimumSwapForIncreasingNumbers.minSwap(new int[]{1, 3, 3, 5, 4}, new int[]{1, 2, 2, 3, 7}));
    }
}