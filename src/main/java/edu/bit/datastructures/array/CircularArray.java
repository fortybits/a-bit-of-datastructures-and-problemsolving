package edu.bit.datastructures.array;

import edu.bit.annotations.difficulty.Easy;
import edu.bit.annotations.topics.Array;

/**
 * Write a function to print circular list starting from given index ind.
 * http://www.geeksforgeeks.org/circular-array/
 */
@Array
@Easy
public class CircularArray {

    // this is a simple O(N) approach that takes O(1) space complexity
    public String circularTraversal(char[] a, int ind) {
        // print from ind-th index to (n+i)th index.
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = ind; i < a.length + ind; i++) {
            stringBuilder.append(a[(i % a.length)]);
        }
        return stringBuilder.toString();
    }
}