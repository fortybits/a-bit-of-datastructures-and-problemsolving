package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class IdentifySwappedNodesTest {

    IdentifySwappedNodes recoverSwappedTree = new IdentifySwappedNodes();

    @Test
    void testFindSwapped() {
        TreeNode treeNode = new TreeNode(50);
        treeNode.right = new TreeNode(70);
        treeNode.left = new TreeNode(20);
        treeNode.left.left = new TreeNode(25);
        treeNode.left.right = new TreeNode(10);
        Assertions.assertArrayEquals(new int[]{25, 10}, recoverSwappedTree.findSwapped(treeNode));


        treeNode = new TreeNode(10);
        treeNode.right = new TreeNode(8);
        treeNode.left = new TreeNode(5);
        treeNode.left.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(20);
        Assertions.assertArrayEquals(new int[]{20, 8}, recoverSwappedTree.findSwapped(treeNode));
    }
}