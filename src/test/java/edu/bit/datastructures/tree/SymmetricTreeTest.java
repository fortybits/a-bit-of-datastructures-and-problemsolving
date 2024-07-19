package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SymmetricTreeTest {

    SymmetricTree symmetricTree = new SymmetricTree();

    @Test
    void testSymmetricTree() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.left = new TreeNode(3);
        node1.left.right = new TreeNode(4);
        node1.right.left = new TreeNode(4);
        node1.right.right = new TreeNode(3);
        Assertions.assertTrue(symmetricTree.isSymmetric(node1));
    }

    @Test
    void testIncorrectSymmetry() {
        TreeNode node1 = new TreeNode(1);
        node1.left = new TreeNode(2);
        node1.right = new TreeNode(2);
        node1.left.right = new TreeNode(3);
        node1.right.right = new TreeNode(3);
        Assertions.assertFalse(symmetricTree.isSymmetric(node1));
    }

}