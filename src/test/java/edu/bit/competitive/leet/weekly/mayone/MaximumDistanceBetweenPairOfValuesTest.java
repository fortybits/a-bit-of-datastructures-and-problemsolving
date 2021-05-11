package edu.bit.competitive.leet.weekly.mayone;

import edu.bit.problemsolving.competitive.leet.weekly.mayone.MaximumDistanceBetweenPairOfValues;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumDistanceBetweenPairOfValuesTest {

    MaximumDistanceBetweenPairOfValues maximumDistanceBetweenPairOfValues = new MaximumDistanceBetweenPairOfValues();

    @Test
    void maxDistance() {
        Assertions.assertEquals(2, maximumDistanceBetweenPairOfValues
                .maxDistance(new int[]{55, 30, 5, 4, 2}, new int[]{100, 20, 10, 10, 5}));

    }
}