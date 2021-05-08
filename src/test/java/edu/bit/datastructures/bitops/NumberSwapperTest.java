package edu.bit.datastructures.bitops;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class NumberSwapperTest {

    NumberSwapper numberSwapper = new NumberSwapper();

    @Test
    void swap() {
        int a = 1672;
        int b = 9332;
        numberSwapper.swap(a, b);
        Assertions.assertEquals(1672, a);
        Assertions.assertEquals(9332, b);
    }

    @Test
    void swapOpt() {
        int a = 1672;
        int b = 9332;
        numberSwapper.swapOpt(a, b);
        Assertions.assertEquals(1672, a);
        Assertions.assertEquals(9332, b);
    }
}