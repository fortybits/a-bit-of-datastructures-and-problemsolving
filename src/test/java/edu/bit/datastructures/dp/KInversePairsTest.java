package edu.bit.datastructures.dp;

import edu.bit.datastructures.dp.KInversePairs;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class KInversePairsTest {

    KInversePairs kInversePairs = new KInversePairs();

    @Test
    void testKInversePairs() {
        Assertions.assertEquals(1, kInversePairs.kInversePairs(3,0));
        Assertions.assertEquals(2, kInversePairs.kInversePairs(3,1));
    }
}