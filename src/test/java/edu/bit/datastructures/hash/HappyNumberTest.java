package edu.bit.datastructures.hash;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HappyNumberTest {

    HappyNumber happyNumber = new HappyNumber();


    @Test
    void testHashSet() {
        Assertions.assertTrue(happyNumber.isHappy(19));
        Assertions.assertFalse(happyNumber.isHappy(2));
    }

}