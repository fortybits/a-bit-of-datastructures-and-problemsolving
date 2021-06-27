package edu.bit.datastructures.array;

/**
 * There are n children standing in a line. Each child is assigned a rating value given in the
 * integer array ratings.
 * <p>
 * You are giving candies to these children subjected to the following requirements:
 * <p>
 * Each child must have at least one candy.
 * Children with a higher rating get more candies than their neighbors.
 * Return the minimum number of candies you need to have to distribute the candies to the children.
 */
public class Candy {
    public int candy(int[] ratings) {
        int up = 0;
        int down = 0;
        int peak = 0;
        int result = 1;
        for (int i = 1; i < ratings.length; i++) {
            if (ratings[i - 1] < ratings[i]) { // greater than previous
                up = up + 1;
                peak = up;
                down = 0;
                result += 1 + up;
            } else if (ratings[i - 1] == ratings[i]) { // same as pervious
                peak = up = down = 0;
                result += 1;
            } else { // smaller than previous
                up = 0;
                down = down + 1;
                result += 1 + down + (peak >= down ? -1 : 0);
            }
        }
        return result;
    }
}