package edu.bit.datastructures.string;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MinimumFlipsToMakeBinaryAlternatingTest {

    MinimumFlipsToMakeBinaryAlternating minimumFlipsToMakeBinaryAlternating = new MinimumFlipsToMakeBinaryAlternating();

    @Test
    void testMinFlips() {
        Assertions.assertEquals(2, minimumFlipsToMakeBinaryAlternating.minimumFlips("111000"));
        Assertions.assertEquals(0, minimumFlipsToMakeBinaryAlternating.minimumFlips("010"));
        Assertions.assertEquals(1, minimumFlipsToMakeBinaryAlternating.minimumFlips("1110"));
        Assertions.assertEquals(0, minimumFlipsToMakeBinaryAlternating.minimumFlips("0"));
        Assertions.assertEquals(2, minimumFlipsToMakeBinaryAlternating.minimumFlips("01001001101"));
    }
}