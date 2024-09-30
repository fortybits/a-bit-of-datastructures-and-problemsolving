package edu.bit.datastructures.recursion;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class PowerCalculationTest {

    PowerCalculation powerCalculation = new PowerCalculation();

    @Test
    void testPowerCalculation() {
        Assertions.assertEquals(9.26100, powerCalculation.myPow(2.10000, 3));
        Assertions.assertEquals(0.25000, powerCalculation.myPow(2.00000, -2));
    }

}