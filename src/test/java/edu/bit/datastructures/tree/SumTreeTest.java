package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumTreeTest {

    SumTree sumTree = new SumTree();

    @Test
    void isSumTree() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(1);
        treeNode.right = new TreeNode(2);
        Assertions.assertTrue(sumTree.isSumTree(treeNode));
    }

    @Test
    void isNotSumTree() {
        TreeNode treeNode = new TreeNode(10);
        treeNode.left = new TreeNode(20);
        treeNode.right = new TreeNode(30);
        treeNode.left.left = new TreeNode(10);
        treeNode.left.right = new TreeNode(10);
        Assertions.assertFalse(sumTree.isSumTree(treeNode));
    }
}