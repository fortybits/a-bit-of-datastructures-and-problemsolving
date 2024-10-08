package edu.bit.datastructures.tree;

import java.util.LinkedList;
import java.util.Queue;

/**
 * Given a binary tree (having distinct node values) root and two node values.
 * The task is to check whether the two nodes with values a and b are cousins.
 * Note: Two nodes of a binary tree are cousins if they have the same depth with different parents.
 */
public class CousinNodes {

    // approach to traverse by level and validate the
    private boolean areCousins(TreeNode root, int a, int b) {
        // base case
        if (root == null) return false;
        // return false if a and b are equal
        if (a == b) return false;

        Queue<TreeNode> q = new LinkedList<>();
        // Push the root node into queue
        q.add(root);

        // variables to check if a and b are found yet.
        boolean aFound = false;
        boolean bFound = false;

        while (!q.isEmpty()) {
            int s = q.size();

            // To simulate level order traversal, only traverse the first s nodes in the queue.
            for (int i = 0; i < s; i++) {
                TreeNode curr = q.poll();

                if (curr.val == a) aFound = true;
                if (curr.val == b) {
                    bFound = true;
                }

                // if a and b are children to the same node, then return false.
                if (curr.left != null && curr.right != null &&
                        ((curr.left.val == a && curr.right.val == b) ||
                                (curr.left.val == b && curr.right.val == a))) {
                    return false;
                }

                // push left node into queue
                if (curr.left != null) q.add(curr.left);

                // Push right node into queue.
                if (curr.right != null) q.add(curr.right);
            }

            // After iteration of one level, following needs to be checked

            // if both a and b are found, return true.
            if (aFound && bFound) return true;

            // if only one of a or b is found in this level, return false.
            if (aFound || bFound) return false;
        }

        return false;
    }

    private boolean isSibling(TreeNode root, int a, int b) {
        // Base case
        if (root == null) return false;

        if (root.left != null && root.right != null && root.left.val == a && root.right.val == b) return true;

        if (root.left != null && root.right != null && root.left.val == b && root.right.val == a) return true;

        return isSibling(root.left, a, b) || isSibling(root.right, a, b);
    }

    private int level(TreeNode root, int value, int lev) {
        // base cases
        if (root == null) return 0;
        if (root.val == value) return lev;

        // Return level if Node is present in left subtree
        int l = level(root.left, value, lev + 1);
        if (l != 0) return l;

        // Else search in right subtree
        return level(root.right, value, lev + 1);
    }

    // using DFS can be helpful to simplify the level count and verifying if the nodes are not siblings
    private boolean isCousins(TreeNode root, int a, int b) {

        // 1. The two Nodes should be on the same level in the binary tree.
        // 2. The two Nodes should not be siblings (means that they should not have the same parent Node).

        if (a == b) return false;

        int aLevel = level(root, a, 1);
        int bLevel = level(root, b, 1);

        // if a or b does not exist in the tree
        if (aLevel == 0 || bLevel == 0) return false;

        return aLevel == bLevel && !isSibling(root, a, b);
    }

}