package edu.bit.datastructures.tree;

/**
 * The vEB Tree is used to ensure a mix of balanced BST and binary array for 1... u elements
 * <p>
 * It supports search, successor, predecessor, insert and delete operations in O(lglgN) time
 * which is faster than any of related data structures like priority queue, binary search tree, etc.
 * https://www.geeksforgeeks.org/van-emde-boas-tree-set-1-basics-and-construction/
 */
public class VEBTree {

    int universeSize;
    int minimum;
    int maximum;
    VEBTree summary;
    VEBTree[] clusters;

    public VEBTree(int size) {
        this.universeSize = size;
        this.minimum = -1;
        this.maximum = -1;

        if (size <= 2) {
            this.summary = null;
            this.clusters = new VEBTree[0];
        } else {
            int noClusters = (size + 1) / 2;

            this.summary = new VEBTree(noClusters);
            this.clusters = new VEBTree[noClusters];

            for (int i = 0; i < noClusters; i++) {
                this.clusters[i] = new VEBTree((size + 1) / 2);
            }
        }
    }

    // Function to return cluster numbers in which key is present
    int high(int x) {
        int div = (this.universeSize + 1) / 2;
        return x / div;
    }

    // Function to return position of x in cluster
    int low(int x) {
        int mod = (this.universeSize + 1) / 2;
        return x % mod;
    }

    // Function to return the index from cluster number and position
    int generateIndex(int x, int y) {
        int ru = (this.universeSize + 1) / 2;
        return x * ru + y;
    }
}