package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class LevelTraversalTest {

    LevelTraversal levelTraversal = new LevelTraversal();

    @Test
    void testLevelOrderTraversal() {
        TreeNode treeNode = new TreeNode(3);
        treeNode.left = new TreeNode(9);
        treeNode.left.left = null;
        treeNode.left.right = null;
        treeNode.right = new TreeNode(20);
        treeNode.right.left = new TreeNode(15);
        treeNode.right.right = new TreeNode(7);
        Assertions.assertEquals(List.of(List.of(3), List.of(9, 20), List.of(15, 7)),
                levelTraversal.levelOrderBFS(treeNode));
    }

    @Test
    void testLevelOrderTraversalOfEmptyTree() {
        Assertions.assertEquals(List.of(),
                levelTraversal.levelOrderBFS(null));
    }
}