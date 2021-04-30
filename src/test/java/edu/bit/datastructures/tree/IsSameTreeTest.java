package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IsSameTreeTest {

    IsSameTree isSameTree = new IsSameTree();

    @Test
    void testIsSameTreeWithValidData() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(2);
        node2.right = new TreeNode(3);
        Assertions.assertTrue(isSameTree.isSameTree(node1, node2));
    }

    @Test
    void testIsSameTreeWithDifferentData() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(3);

        TreeNode node2 = new TreeNode(1);
        node2.right = new TreeNode(3);
        Assertions.assertFalse(isSameTree.isSameTree(node1, node2));
    }

    @Test
    void testIsSameTreeWithMismatchedData() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(1);

        TreeNode node2 = new TreeNode(1);
        node2.left = new TreeNode(1);
        node2.right = new TreeNode(2);
        Assertions.assertFalse(isSameTree.isSameTree(node1, node2));
    }
}