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

    double findMedianSortedArrays(int[] nums1, int[] nums2) {
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

    double findMedianSortedArraysUsingBinarySearch(int[] first, int[] second) {
        int n = first.length;
        int m = second.length;
        if (n < m) {
            return findMedianSortedArraysUsingBinarySearch(second, first);    // Make sure second array is shorter
        }

        int lo = 0;
        int hi = m * 2;
        while (lo <= hi) {
            int mid2 = (lo + hi) / 2;   // Try Cut 2
            int mid1 = n + m - mid2;  // Calculate Cut 1 accordingly

            double L1 = (mid1 == 0) ? Integer.MIN_VALUE : first[(mid1 - 1) / 2];    // Get L1, R1, L2, R2 respectively
            double L2 = (mid2 == 0) ? Integer.MIN_VALUE : second[(mid2 - 1) / 2];
            double R1 = (mid1 == n * 2) ? Integer.MAX_VALUE : first[(mid1) / 2];
            double R2 = (mid2 == m * 2) ? Integer.MAX_VALUE : second[(mid2) / 2];

            if (L1 > R2) lo = mid2 + 1;        // A1's lower half is too big; need to move C1 left (C2 right)
            else if (L2 > R1) hi = mid2 - 1;    // A2's lower half too big; need to move C2 left.
            else return (Math.max(L1, L2) + Math.min(R1, R2)) / 2;    // Otherwise, that's the right cut.
        }
        return -1;
    }
}