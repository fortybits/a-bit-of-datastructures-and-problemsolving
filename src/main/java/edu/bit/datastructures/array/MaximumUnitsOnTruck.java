package edu.bit.datastructures.array;

import java.util.Arrays;

/**
 * You are assigned to put some amount of boxes onto one truck.
 * You are given a 2D array boxTypes, where boxTypes[i] = [numberOfBoxesi, numberOfUnitsPerBoxi]:
 * <p>
 * numberOfBoxesi is the number of boxes of type i.
 * numberOfUnitsPerBoxi is the number of units in each box of the type i.
 * You are also given an integer truckSize, which is the maximum number of boxes that can be put on the truck.
 * You can choose any boxes to put on the truck as long as the number of boxes does not exceed truckSize.
 * <p>
 * Return the maximum total number of units that can be put on the truck.
 */
public class MaximumUnitsOnTruck {

    public int maximumUnits(int[][] boxTypes, int truckSize) {
        Arrays.sort(boxTypes, (a, b) -> Integer.compare(b[1], a[1]));
        int i = 0;
        int maxUnit = 0;
        while (truckSize > 0 && i < boxTypes.length) {
            int boxes = Math.min(boxTypes[i][0], truckSize);
            truckSize = truckSize - boxes;
            maxUnit = maxUnit + (boxes * boxTypes[i][1]);
            i++;
        }
        return maxUnit;
    }
}