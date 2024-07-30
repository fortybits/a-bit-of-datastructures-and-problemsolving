package edu.bit.datastructures.stack;

import java.util.Stack;

/**
 * Find the largest rectangular area possible in a given histogram
 * where the largest rectangle can be made of a number of contiguous bars
 * whose heights are given in an array.
 * For simplicity, assume that all bars have the same width and the width is 1 unit.
 */
public class LargestRectangularArea {

    /**
     * We need to know the index of the first smaller (smaller than ‘x’) bar on the left of ‘x’
     * and the index of the first smaller bar on the right of ‘x’.
     * Let us call these indexes as ‘left index’ and ‘right index’ respectively.
     * We traverse all bars from left to right and maintain a stack of bars.
     * Every bar is pushed to stack once. A bar is popped from the stack when a bar of smaller height is seen.
     * When a bar is popped, we calculate the area with the popped bar as the smallest bar.
     */
    static int getMaxArea(int[] hist, int n) {

        // Create an empty stack. The stack holds indexes of hist[] array.
        // The bars stored in stack are always in increasing order of their heights.
        Stack<Integer> s = new Stack<>();

        int maxiumumArea = 0; // Initialize max area
        int top; // To store top of stack
        int areaWithTop; // To store area with top bar as the smallest bar

        // Run through all bars of given histogram
        int i = 0;
        while (i < n) {
            // If this bar is higher than the bar on top stack, push it to stack
            if (s.empty() || hist[s.peek()] <= hist[i]) {
                s.push(i++);
            }

            // If this bar is lower than top of stack, then
            // calculate area of rectangle with stack top as
            // the smallest (or minimum height) bar. 'i' is
            // 'right index' for the top and element before
            // top in stack is 'left index'
            else {
                top = s.pop(); // store the top index, pop the top

                // Calculate the area with hist[tp] stack as smallest bar
                int width = s.empty() ? i : i - s.peek() - 1;
                areaWithTop = hist[top] * width;

                // update max area, if needed
                if (maxiumumArea < areaWithTop)
                    maxiumumArea = areaWithTop;
            }
        }

        // Now pop the remaining bars from stack and calculate area with every popped bar as the smallest bar
        while (!s.empty()) {
            top = s.pop();
            areaWithTop = hist[top] * (s.empty() ? i : i - s.peek() - 1);

            if (maxiumumArea < areaWithTop)
                maxiumumArea = areaWithTop;
        }

        return maxiumumArea;
    }
}
