package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class DiameterOfBinaryTreeTest {

    DiameterOfBinaryTree diameterOfBinaryTree = new DiameterOfBinaryTree();

    @Test
    void diameterOfBinaryTree() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.left.right = new TreeNode(5);
        Assertions.assertEquals(3, diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
        treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        Assertions.assertEquals(1, diameterOfBinaryTree.diameterOfBinaryTree(treeNode));
    }

}