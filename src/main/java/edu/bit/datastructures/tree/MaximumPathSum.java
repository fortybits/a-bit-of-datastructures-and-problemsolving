package edu.bit.datastructures.tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them. A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * https://leetcode.com/problems/binary-tree-maximum-path-sum/description/
 */
public class MaximumPathSum {

    int maxSum;

    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        maxSumHelper(root);
        return maxSum; // as maxSum will always store the result

    }

    public int maxSumHelper(TreeNode root) {

        // base case
        if (root == null) return 0;

        // recurse through left and right subtree
        int leftMax = maxSumHelper(root.left);
        int rightMax = maxSumHelper(root.right);

        // finding all the four paths and the maximum between all of them
        int maxRightLeft = Math.max(leftMax, rightMax);
        int maxOneNodeRoot = Math.max(root.val, (root.val + maxRightLeft));
        int maxAll = Math.max(maxOneNodeRoot, leftMax + rightMax + root.val);

        // Storing the result in the maxSum holder
        maxSum = Math.max(maxSum, maxAll);

        // returning the value if root was part of the answer
        return maxOneNodeRoot;

    }
}