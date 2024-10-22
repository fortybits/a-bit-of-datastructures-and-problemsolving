package org.google;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CoinChangeTest {

    CoinChange coinChange = new CoinChange();

    @Test
    void testCoinChange() {
        Assertions.assertEquals(3, coinChange.coinChange(new int[]{1, 2, 5}, 11));
        Assertions.assertEquals(-1, coinChange.coinChange(new int[]{2}, 3));
        Assertions.assertEquals(5, coinChange.coinChange(new int[]{2}, 10));
        Assertions.assertEquals(0, coinChange.coinChange(new int[]{1}, 0));
        Assertions.assertEquals(-1, coinChange.coinChange(new int[]{}, 1));
    }

}