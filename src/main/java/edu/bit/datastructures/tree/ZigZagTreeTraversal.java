package edu.bit.datastructures.tree;

import java.util.Stack;

/**
 * Write a function to print ZigZag order traversal of a binary tree
 */
public class ZigZagTreeTraversal {

    // O(N) runtime complexity with two stacks of O(n)
    void printZigZagTraversal(TreeNode rootNode) {

        // if null then return
        if (rootNode == null) {
            return;
        }

        // declare two stacks
        Stack<TreeNode> currentLevel = new Stack<>();
        Stack<TreeNode> nextLevel = new Stack<>();

        // push the root
        currentLevel.push(rootNode);
        boolean leftToRight = true;

        // check if stack is empty
        while (!currentLevel.isEmpty()) {

            // pop out of stack
            TreeNode node = currentLevel.pop();

            // print the data in it
            System.out.print(node.val + " ");

            // store data according to current order.
            if (leftToRight) {
                if (node.left != null) {
                    nextLevel.push(node.left);
                }

                if (node.right != null) {
                    nextLevel.push(node.right);
                }
            } else {
                if (node.right != null) {
                    nextLevel.push(node.right);
                }

                if (node.left != null) {
                    nextLevel.push(node.left);
                }
            }

            if (currentLevel.isEmpty()) {
                leftToRight = !leftToRight;
                Stack<TreeNode> temp = currentLevel;
                currentLevel = nextLevel;
                nextLevel = temp;
            }
        }
    }
}