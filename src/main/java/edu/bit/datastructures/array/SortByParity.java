package edu.bit.datastructures.array;

/**
 * Given an integer array nums, move all the even integers at the beginning of the array followed by all the odd integers.
 * <p>
 * Return any array that satisfies this condition.
 */
public class SortByParity {

    public int[] sortArrayByParity(int[] numbers) {
        int countEven = 0;
        for (int num : numbers) {
            if (num % 2 == 0) countEven++;
        }
        int[] output = new int[numbers.length];
        int remaining = 0;
        for (int num : numbers) {
            if (num % 2 == 1) {
                output[countEven] = num;
                countEven++;
            } else {
                output[remaining] = num;
                remaining++;
            }
        }
        return output;
    }

}
