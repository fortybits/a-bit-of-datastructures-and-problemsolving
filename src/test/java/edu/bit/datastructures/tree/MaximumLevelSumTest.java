package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MaximumLevelSumTest {

    MaximumLevelSum maximumLevelSum = new MaximumLevelSum();

    @Test
    void testMaxLevelSumWithNegativeValues() {
        // [-100,-200,-300,-20,-5,-10,null]
        TreeNode treeNode1 = new TreeNode(-100);
        treeNode1.left = new TreeNode(-200);
        treeNode1.right = new TreeNode(-300);
        treeNode1.left.left = new TreeNode(-20);
        treeNode1.left.right = new TreeNode(-5);
        treeNode1.right.left = new TreeNode(-10);
        Assertions.assertEquals(3, maximumLevelSum.maxLevelSum(treeNode1));
    }


    @Test
    void testMaxLevelSum() {
        // [1,7,0,7,-8,null,null]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(-8);
        Assertions.assertEquals(2, maximumLevelSum.maxLevelSum(treeNode));
    }
}