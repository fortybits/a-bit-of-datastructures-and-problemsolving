package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class MergeTwoBinarySearchTreeTest {

    MergeTwoBinarySearchTree mergeTwoBST = new MergeTwoBinarySearchTree();

    @Test
    void mergeBST() {
        TreeNode first = new TreeNode(5);
        first.left = new TreeNode(3);
        first.right = new TreeNode(6);
        first.left.left = new TreeNode(2);
        first.left.right = new TreeNode(4);

        TreeNode second = new TreeNode(2);
        second.left = new TreeNode(1);
        second.right = new TreeNode(3);
        second.right.right = new TreeNode(7);
        second.right.right.left = new TreeNode(6);

        List<Integer> result = mergeTwoBST.mergeBST(first, second);
        Assertions.assertEquals(List.of(1, 2, 2, 3, 3, 4, 5, 6, 6, 7), result);
    }
}