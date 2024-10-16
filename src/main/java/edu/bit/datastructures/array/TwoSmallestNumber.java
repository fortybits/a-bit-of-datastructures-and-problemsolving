package edu.bit.datastructures.array;

/***
 * https://www.geeksforgeeks.org/to-find-smallest-and-second-smallest-element-in-an-array
 */
public class TwoSmallestNumber {

    public void print2Smallest(int[] arr, int arr_size) {
        int i, first, second;

        /* There should be atleast two elements */
        if (arr_size < 2) {
            System.out.println("Invalid Input!");
            return;
        }

        first = second = Integer.MAX_VALUE;
        for (i = 0; i < arr_size; i++) {
      /* If current element is smaller than first
      then update both first and second */
            if (arr[i] < first) {
                second = first;
                first = arr[i];
            }

      /* If arr[i] is in between first and second
      then update second  */
            else if (arr[i] < second && arr[i] != first) second = arr[i];
        }
        if (second == Integer.MAX_VALUE) {
            System.out.println("There is no second smallest element.");
        } else {
            System.out.println(
                    "The smallest element is " + first + " and second smallest element is " + second);
        }
    }
}
