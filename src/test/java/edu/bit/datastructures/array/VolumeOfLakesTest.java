package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VolumeOfLakesTest {

    VolumeOfLakes volumeOfLakes = new VolumeOfLakes();

    @Test
    void testCapacity() {
        Assertions.assertEquals(15,
                volumeOfLakes.volumeOfLakes(new int[]{1, 3, 2, 4, 1, 3, 1, 4, 5, 2, 2, 1, 4, 2, 2}));
    }

}