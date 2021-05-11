package edu.bit.datastructures.bitops;

import edu.bit.annotations.topics.BitOps;

/**
 * Write a function to swap a number in place(that is without a temporary variables)
 */
@BitOps
public class NumberSwapper {

    // using no third variable, calculate the difference and proceed
    public void swap(int a, int b) {
        // Example for a = 9, b = 4
        a = a - b; // a = 9 - 4 = 5
        b = a + b; // b = 5 + 4 = 9
        a = b - a; // a = 9 - 5
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }

    // Using XOR of values instead of subtraction
    public void swapOpt(int a, int b) {
        a = a ^ b;
        b = a ^ b;
        a = a ^ b;
        System.out.println("a: " + a);
        System.out.println("b: " + b);
    }
}