package edu.bit.datastructures.tree;

/**
 * Given the roots of two binary trees p and q, write a function to check if they are the same or not.
 * Two binary trees are considered the same if they are structurally identical,
 * and the nodes have the same value.
 */
public class IsSameTree {

    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) {
            return true;
        }

        return p != null && q != null && p.val == q.val &&
                isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
    }
}