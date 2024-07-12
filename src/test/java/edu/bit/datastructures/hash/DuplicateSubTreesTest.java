package edu.bit.datastructures.hash;

import edu.bit.datastructures.tree.TreeNode;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class DuplicateSubTreesTest {


    DuplicateSubTrees duplicateSubTrees = new DuplicateSubTrees();

    @Test
    void testDuplicateSubTrees() {
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(2);
        treeNode.right = new TreeNode(3);
        treeNode.left.left = new TreeNode(4);
        treeNode.right.left = new TreeNode(2);
        treeNode.right.right = new TreeNode(4);
        treeNode.right.left.left = new TreeNode(2);

        TreeNode exp1 = new TreeNode(2);
        exp1.left = new TreeNode(4);
        TreeNode exp2 = new TreeNode(2);
        Assertions.assertIterableEquals(List.of(exp1, exp2), duplicateSubTrees.findDuplicateSubtrees(treeNode));
    }
}