package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * Given a rectangular cake with height h and width w, and two arrays of integers horizontalCuts and verticalCuts
 * where horizontalCuts[i] is the distance from the top of the rectangular cake to the ith horizontal cut and similarly,
 * verticalCuts[j] is the distance from the left of the rectangular cake to the jth vertical cut.
 * <p>
 * Return the maximum area of a piece of cake after you cut at each horizontal and vertical position provided
 * in the arrays horizontalCuts and verticalCuts. Since the answer can be a huge number, return this modulo 10^9 + 7.
 */
public class MaximumCakeArea {

    public int maxArea(int h, int w, int[] horizontalCuts, int[] verticalCuts) {
        Arrays.sort(horizontalCuts); // O(hlogh)
        int maxHeight = horizontalCuts[0];
        for (int i = 1; i < horizontalCuts.length; i++) {
            int currentHeight = horizontalCuts[i] - horizontalCuts[i - 1];
            maxHeight = Math.max(maxHeight, currentHeight);
        }
        maxHeight = Math.max(maxHeight, h - horizontalCuts[horizontalCuts.length - 1]);

        Arrays.sort(verticalCuts); // O(wlogw)
        int maxWidth = verticalCuts[0];
        for (int j = 1; j < verticalCuts.length; j++) {
            int currentWidth = verticalCuts[j] - verticalCuts[j - 1];
            maxWidth = Math.max(maxWidth, currentWidth);
        }
        maxWidth = Math.max(maxWidth, w - verticalCuts[verticalCuts.length - 1]);

        return (int) ((long) maxHeight * maxWidth % 1000000007);
    }
}
