package edu.bit.datastructures.array;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CanBalanceTest {

    CanBalance canBalance = new CanBalance();

    @Test
    void testCanBalance() {
        Assertions.assertTrue(canBalance.canBalance(new int[]{1, 1, 1, 2, 1}));
        Assertions.assertFalse(canBalance.canBalance(new int[]{2, 1, 1, 2, 1}));
        Assertions.assertTrue(canBalance.canBalance(new int[]{10, 10}));
        Assertions.assertFalse(canBalance.canBalance(new int[]{10, 10, 10}));
    }

}