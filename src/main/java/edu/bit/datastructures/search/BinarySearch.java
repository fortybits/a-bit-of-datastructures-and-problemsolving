package edu.bit.datastructures.search;

public class BinarySearch {
    public int search(int[] array, int target) {
        int n = array.length;
        int low = 0;
        int high = n - 1;

        while (low <= high) {
            int mid = (low + high) / 2; // this may cause integer overflow
            if (array[mid] == target)
                return mid;
            else if (array[mid] < target)
                low = mid + 1;
            else
                high = mid - 1;
        }

        return -1;
    }
}
