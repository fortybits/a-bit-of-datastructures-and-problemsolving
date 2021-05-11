package edu.bit.competitive.leet.weekly.mayone;

import edu.bit.problemsolving.competitive.leet.weekly.mayone.MaxSubArrayMinProduct;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaxSubArrayMinProductTest {
    MaxSubArrayMinProduct maxSubArrayMinProduct = new MaxSubArrayMinProduct();

    @Test
    void maxSumMinProduct() {
        Assertions.assertEquals(14,
                maxSubArrayMinProduct.maxSumMinProduct(new int[]{1, 2, 3, 2}));
        Assertions.assertEquals(18,
                maxSubArrayMinProduct.maxSumMinProduct(new int[]{2, 3, 3, 1, 2}));
        Assertions.assertEquals(60,
                maxSubArrayMinProduct.maxSumMinProduct(new int[]{3, 1, 5, 6, 4, 2}));
    }
}