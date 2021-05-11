package edu.bit.datastructures.tree;

import edu.bit.annotations.difficulty.Medium;
import edu.bit.annotations.topics.Heap;

import java.util.Comparator;
import java.util.PriorityQueue;

/**
 * The median of a set of integers is the midpoint value of the data set for which an
 * equal number of integers are less than and greater than the value.
 * To find the median, you must first sort your set of integers in non-decreasing order, then:
 * <p>
 * If your set contains an odd number of elements,
 * the median is the middle element of the sorted sample.
 * <p>
 * If your set contains an even number of elements,
 * the median is the average of the two middle elements of the sorted sample.
 * Given an input stream of  integers, perform the following task for each  integer:
 * Add the ith integer to a running list of integers.
 * Find the median of the updated list (i.e., for the first element through the ith element).
 */
@Medium
@Heap
public class RunningMedian {

    private static final PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Comparator.reverseOrder());
    private static final PriorityQueue<Integer> minHeap = new PriorityQueue<>();

    // the approach of splitting the values into two halves such as maintaining
    // the smallest at one and largest of another should help derive the median
    // this can be achieved using two different heaps such as the following
    // ________ (maxHeap)______ (median) _______(minHeap) _________
    public double[] medianTracker(int[] array) {
        double[] medians = new double[array.length];
        for (int i = 0; i < array.length; i++) {
            addNumber(array[i]);
            medians[i] = getMedian();
        }
        return medians;
    }

    // the addition is build on the assumption that maxHeap will never have fewer elements than minHeap
    // notice, that like a balanced tree, the size of the heaps shouldn't differ by more than oe at any point
    private void addNumber(int n) {
        if (maxHeap.isEmpty()) {
            maxHeap.add(n);
        } else if (maxHeap.size() == minHeap.size()) {
            if (n < minHeap.peek()) {
                maxHeap.add(n);
            } else {
                minHeap.add(n);
                maxHeap.add(minHeap.remove());
            }
        } else if (maxHeap.size() > minHeap.size()) {
            if (n > maxHeap.peek()) {
                minHeap.add(n);
            } else {
                maxHeap.add(n);
                minHeap.add(maxHeap.remove());
            }
        }
    }

    private double getMedian() {
        if (maxHeap.isEmpty()) {
            return 0;
        } else if (maxHeap.size() == minHeap.size()) {
            return (maxHeap.peek() + minHeap.peek()) / 2.0;
        } else {
            return maxHeap.peek();
        }
    }
}
