package edu.bit.datastructures.array;

/**
 * Given two sorted arrays nums1 and nums2 of size m and n respectively,
 * return the median of the two sorted arrays.
 * <p>
 * The overall run time complexity should be O(log (m+n)).
 */
public class MedianOfSortedArrays {

    // one of the ways to find the median would be to merge the arrays and find the middle element(s)
    // this would take runtime of (m+n) and at the same time space complexity would be  O(m+n)

    // to improve the runtime, the data structure to store these values could be similar to a tree or
    // we could plan for a divide and conquer to find the middle element
    void findMedianSortedArraysThoughtProcess(int[] nums1, int[] nums2) {
        int m = nums1.length;
        int n = nums2.length;
        int totalLength = m + n;
        if (totalLength % 2 == 0) {
            // (totalLength / 2 + (totalLength / 2) - 1) / 2.0d;
        } else {
            // totalLength / 2;
        }
    }

    double findMedianSortedArrays(int nums1[], int nums2[]) {
        int index1 = 0;
        int index2 = 0;
        int firstMedian = 0;
        int secondMedian = 0;
        for (int i = 0; i <= (nums1.length + nums2.length) / 2; i++) {
            firstMedian = secondMedian;
            if (index1 == nums1.length) {
                secondMedian = nums2[index2];
                index2++;
            } else if (index2 == nums2.length) {
                secondMedian = nums1[index1];
                index1++;
            } else if (nums1[index1] < nums2[index2]) {
                secondMedian = nums1[index1];
                index1++;
            } else {
                secondMedian = nums2[index2];
                index2++;
            }
        }

        // the median is the average of two numbers
        if ((nums1.length + nums2.length) % 2 == 0) {
            return (float) (firstMedian + secondMedian) / 2;
        }

        return secondMedian;
    }
}