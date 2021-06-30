package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class FirstCommonAncestorTest {

    FirstCommonAncestor firstCommonAncestor = new FirstCommonAncestor();

    @Test
    void testLowestCommonAncestor() {
        TreeNode treeNode = new TreeNode(3);
        TreeNode p = new TreeNode(5);
        treeNode.left = p;
        treeNode.left.left = new TreeNode(6);
        treeNode.left.right = new TreeNode(2);
        treeNode.left.right.left = new TreeNode(7);
        treeNode.left.right.right = new TreeNode(4);
        TreeNode q = new TreeNode(1);
        treeNode.right = q;
        treeNode.right.left = new TreeNode(0);
        treeNode.right.right = new TreeNode(8);

        Assertions.assertEquals(3, firstCommonAncestor.lowestCommonAncestor(treeNode, p, q).val);
    }

}