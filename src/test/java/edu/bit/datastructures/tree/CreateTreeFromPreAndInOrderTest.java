package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class CreateTreeFromPreAndInOrderTest {

    CreateTreeFromPreAndInOrder createTreeFromPreAndInOrder = new CreateTreeFromPreAndInOrder();
    LevelTraversal levelTraversal = new LevelTraversal();

    @Test
    void testBuildTree() {
        TreeNode treeNode = createTreeFromPreAndInOrder.buildTree(new int[]{3, 9, 20, 15, 7}, new int[]{9, 3, 15, 20, 7});
        Assertions.assertEquals(List.of(3, 9, 20, 15, 7),
                levelTraversal.flattenLevelOrder(treeNode));

    }

    @Test
    void testBuildTreeWithSingleElement() {
        TreeNode treeNode = createTreeFromPreAndInOrder.buildTree(new int[]{-1}, new int[]{-1});
        Assertions.assertEquals(-1, treeNode.val);
        Assertions.assertNull(treeNode.left);
        Assertions.assertNull(treeNode.right);
    }
}