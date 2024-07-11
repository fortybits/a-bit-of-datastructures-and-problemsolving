package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumIndexSumTest {

    MinimumIndexSum minimumIndexSum = new MinimumIndexSum();

    @Test
    void testMinSumIndex() {
        Assertions.assertArrayEquals(new String[]{"Shogun"},
                minimumIndexSum.findMinimumSumIndex(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"Piatti", "The Grill at Torrey Pines", "Hungry Hunter Steakhouse", "Shogun"}));
        Assertions.assertArrayEquals(new String[]{"Shogun"},
                minimumIndexSum.findMinimumSumIndex(new String[]{"Shogun", "Tapioca Express", "Burger King", "KFC"},
                        new String[]{"KFC", "Shogun", "Burger King"}));
        Assertions.assertArrayEquals(new String[]{"sad", "happy"},
                minimumIndexSum.findMinimumSumIndex(new String[]{"happy", "sad", "good"},
                        new String[]{"sad", "happy", "good"}));
    }

}