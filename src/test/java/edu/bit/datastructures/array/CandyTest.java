package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CandyTest {

    Candy candy = new Candy();

    @Test
    void testCandy() {
        Assertions.assertEquals(5, candy.candy(new int[]{1, 0, 2}));
        Assertions.assertEquals(4, candy.candy(new int[]{1, 2, 2}));
    }
}