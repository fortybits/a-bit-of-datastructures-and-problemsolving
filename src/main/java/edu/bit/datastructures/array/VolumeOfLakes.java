package edu.bit.datastructures.array;

/**
 * Given an array of positive integers representing 2-D bar heights,
 * design an algorithm (or write a function) that can compute the total volume (capacity) of water
 * that could be held in all lakes on such an island given an array of the heights of the bars.
 * Assume an elevation map where the width of each bar is 1.
 * <p>
 * Example: Given [1,3,2,4,1,3,1,4,5,2,2,1,4,2,2],
 * return 15 (3 bodies of water with volumes of 1,7,7 yields total volume of 15)
 */
public class VolumeOfLakes {

    // first approach that comes to mind is finding two maxima as we iterate and then calculating the volume
    // one modification would be for the case where another maxima can result in increased volume storage e.g. 4,3,4
    // so, we can continue to accumulate more in capacity
    int volumeOfLakes(int[] height) {
        int trappedWater = 0;
        int leftIndex = 0;
        int rightIndex = height.length - 1;
        int leftMax = 0;
        int rightMax = 0;

        while (leftIndex < rightIndex) {
            if (height[leftIndex] <= height[rightIndex]) {
                leftMax = Math.max(leftMax, height[leftIndex]);
                trappedWater += Math.max(0, leftMax - height[leftIndex]);
                leftIndex += 1;
            } else {
                rightMax = Math.max(rightMax, height[rightIndex]);
                trappedWater += Math.max(0, rightMax - height[rightIndex]);
                rightIndex -= 1;
            }
        }
        return trappedWater;
    }

    // considering
}
