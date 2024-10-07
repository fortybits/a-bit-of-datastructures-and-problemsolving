package edu.bit.datastructures.tree;

/**
 * A path in a binary tree is a sequence of nodes where each pair of adjacent nodes in the sequence has an edge connecting them.
 * A node can only appear in the sequence at most once. Note that the path does not need to pass through the root.
 * <p>
 * The path sum of a path is the sum of the node's values in the path.
 * <p>
 * Given the root of a binary tree, return the maximum path sum of any non-empty path.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes in the tree is in the range [1, 3 * 104].
 * -1000 <= Node.val <= 1000
 */
public class BinaryTreeMaximumPathSum {

    // entire tree couldn't be accounted since a node can be considered only once
    // a node can be either included or not : max of sum when included vs when not included might help
    // question: which node to start off with and which direction to further proceed in
    // start with root, consider including root, not including root (only left) and not including root (only right)
    int maxValue = Integer.MIN_VALUE;

    public int maxPathSum(TreeNode root) {
        maxPathDown(root);
        return maxValue;
    }

    private int maxPathDown(TreeNode node) {
        if (node == null) return 0;
        int left = Math.max(0, maxPathDown(node.left));
        int right = Math.max(0, maxPathDown(node.right));
        int sumIncluding = left + right + node.val;
        // but while including left or right, one would have to ensure that only one child node can further be selected
        maxValue = Math.max(maxValue, sumIncluding);
        return Math.max(left, right) + node.val;
    }
}
