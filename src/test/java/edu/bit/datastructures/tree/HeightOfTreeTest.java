package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class HeightOfTreeTest {

    HeightOfTree heightOfTree = new HeightOfTree();

    @Test
    void getHeightForSymmetricalTree() {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        Assertions.assertEquals(2, heightOfTree.getHeight(treeNode));
    }

    @Test
    void getHeightForStraightTree() {
        TreeNode treeNode = new TreeNode(4);
        treeNode.left = new TreeNode(2);
        treeNode.left.right = new TreeNode(3);
        Assertions.assertEquals(3, heightOfTree.getHeight(treeNode));
    }
}