package edu.bit.datastructures.tree;

import java.util.PriorityQueue;

public class HeapOperations {

    public void minHeapOperations(int Q, int[][] values) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int i = 0; i < Q; i++) {
            int op = values[i][0];
            if (op == 1) {
                int val = values[i][1];
                minHeap.add(val);
            }
            if (op == 2) {
                int val = values[i][1];
                minHeap.remove(val);
            }
            if (op == 3) {
                System.out.println(minHeap.peek());
            }
        }
    }

    // todo implement heap


}