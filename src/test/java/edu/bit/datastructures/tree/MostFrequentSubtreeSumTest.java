package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

class MostFrequentSubtreeSumTest {

    MostFrequentSubtreeSum mostFrequentSubtreeSum = new MostFrequentSubtreeSum();

    @Test
    void testFrequentTreeSumForSingleMostFrequentValue() {
        // [5, 2, -5]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-5);
        Assertions.assertArrayEquals(new int[]{2},
                Arrays.stream(mostFrequentSubtreeSum.findFrequentTreeSum(root)).sorted().toArray());
    }

    @Test
    void testFrequentTreeSumForAllUniqueSums() {
        // [5, 2, -3]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(2);
        root.right = new TreeNode(-3);
        Assertions.assertArrayEquals(new int[]{-3, 2, 4},
                Arrays.stream(mostFrequentSubtreeSum.findFrequentTreeSum(root)).sorted().toArray());
    }

    @Test
    void testFrequentTreeSumForEmptyNodes() {
        // [5, 14, null, 1]
        TreeNode root = new TreeNode(5);
        root.left = new TreeNode(14);
        root.left.left = new TreeNode(1);
        Assertions.assertArrayEquals(new int[]{1, 15, 20},
                Arrays.stream(mostFrequentSubtreeSum.findFrequentTreeSum(root)).sorted().toArray());
    }
}