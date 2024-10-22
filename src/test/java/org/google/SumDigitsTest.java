package org.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumDigitsTest {

    SumDigits sumDigits = new SumDigits();

    @Test
    void testSumDigits() {
        Assertions.assertEquals(123, sumDigits.sumNumbers("abc123xyz"));
        Assertions.assertEquals(44, sumDigits.sumNumbers("aa11b33"));
        Assertions.assertEquals(18, sumDigits.sumNumbers("7 11"));
        Assertions.assertEquals(0, sumDigits.sumNumbers("Chocolate"));
        Assertions.assertEquals(7, sumDigits.sumNumbers("5hoco1a1e"));
        Assertions.assertEquals(1245, sumDigits.sumNumbers("a1234bb11"));
        Assertions.assertEquals(25, sumDigits.sumNumbers("a22bbb3"));
    }

}