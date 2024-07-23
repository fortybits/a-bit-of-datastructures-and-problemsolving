package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.List;

class RightSideViewTest {

    RightSideView rightSideView = new RightSideView();

    @Test
    void testRightSideView() {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);

        Assertions.assertEquals(List.of(1, 3, 4), rightSideView.rightSideView(root));
    }

}