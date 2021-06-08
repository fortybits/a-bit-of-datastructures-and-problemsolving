package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CreateTreeFromPreAndInOrderTest {

    CreateTreeFromPreAndInOrder createTreeFromPreAndInOrder = new CreateTreeFromPreAndInOrder();

    @Test
    void testBuildTree() {
        TreeNode treeNode1 = createTreeFromPreAndInOrder.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Assertions.assertAll(
                () -> Assertions.assertEquals(3, treeNode1.val),
                () -> Assertions.assertEquals(9, treeNode1.left.val),
                () -> Assertions.assertEquals(20, treeNode1.right.val),
                () -> Assertions.assertEquals(15, treeNode1.right.left.val),
                () -> Assertions.assertEquals(7, treeNode1.right.right.val)
        );
    }

    @Test
    void testBuildTreeWithSingleElement() {

        TreeNode treeNode2 = createTreeFromPreAndInOrder.buildTree(new int[]{-1}, new int[]{-1});
        Assertions.assertEquals(-1, treeNode2.val);
        Assertions.assertNull(treeNode2.left);
        Assertions.assertNull(treeNode2.right);
    }
}