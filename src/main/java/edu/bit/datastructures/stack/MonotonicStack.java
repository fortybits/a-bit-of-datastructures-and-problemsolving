package edu.bit.datastructures.stack;

import java.util.ArrayDeque;
import java.util.Deque;

/**
 * A monotonic stack is a special data structure used in algorithmic problem-solving.
 * Monotonic Stack maintaining elements in either increasing or decreasing order.
 * It is commonly used to efficiently solve problems such as finding the next greater or smaller element in an array etc.
 */
public class MonotonicStack {

    public static int[] monotonicIncreasing(int[] nums) {
        Deque<Integer> stack = new ArrayDeque<>();

        // Traverse the array
        for (int num : nums) {
            // While stack is not empty AND top of stack is more than the current element
            while (!stack.isEmpty() && stack.peekLast() > num) {
                // Pop the top element from the stack
                stack.pollLast();
            }
            // Push the current element into the stack
            stack.offerLast(num);
        }

        // Construct the result array from the stack
        int[] result = new int[stack.size()];
        int index = stack.size() - 1;
        while (!stack.isEmpty()) {
            result[index--] = stack.pollLast();
        }

        return result;
    }
}
