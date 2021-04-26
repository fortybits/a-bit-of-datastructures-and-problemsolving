package edu.bit.datastructures.tree;

/**
 * Given the root of a binary tree, the level of its root is 1, the level of its children is 2, and so on.
 * Return the smallest level x such that the sum of all the values of nodes at level x is maximal.
 */
public class MaximumLevelSum {

    public static void main(String[] args) {
        MaximumLevelSum maximumLevelSum = new MaximumLevelSum();
        // [1,7,0,7,-8,null,null]
        TreeNode treeNode = new TreeNode(1);
        treeNode.left = new TreeNode(7);
        treeNode.right = new TreeNode(0);
        treeNode.left.left = new TreeNode(7);
        treeNode.left.right = new TreeNode(-8);
        System.out.println(maximumLevelSum.maxLevelSum(treeNode));

        // [-100,-200,-300,-20,-5,-10,null]
        TreeNode treeNode1 = new TreeNode(-100);
        treeNode1.left = new TreeNode(-200);
        treeNode1.right = new TreeNode(-300);
        treeNode1.left.left = new TreeNode(-20);
        treeNode1.left.right = new TreeNode(-5);
        treeNode1.right.left = new TreeNode(-10);
        System.out.println(maximumLevelSum.maxLevelSum(treeNode1));
    }

    public int maxLevelSum(TreeNode root) {
        int ht = getHeight(root); // O(N)
        long[] perLevelSum = new long[ht];
        calculateLevelSum(root, 0, perLevelSum); // O(N)
        return maxLevelSum(perLevelSum) + 1; // O(K)
    }

    private int maxLevelSum(long[] perLevelSum) {
        long max = Long.MIN_VALUE;
        int level = 0;
        for (int i = 0; i < perLevelSum.length; i++) {
            long v = perLevelSum[i];
            if (max < v) {
                max = v;
                level = i;
            }
        }
        return level;
    }

    // for N nodes, we visited each of them to find their individual depth, hence this is O(N)
    int getHeight(TreeNode root) {
        if (root.left == null && root.right == null) {
            return 1;
        }

        int left = 0;
        if (root.left != null) {
            left = getHeight(root.left);
        }

        int right = 0;
        if (root.right != null) {
            right = getHeight(root.right);
        }

        return (Math.max(left, right) + 1);
    }

    // this is also visited per each TreeNode to fill in the sum, hence O(N)
    void calculateLevelSum(TreeNode node, int level, long sum[]) {
        if (node == null) {
            return;
        }
        sum[level] = sum[level] + node.data;

        calculateLevelSum(node.left, level + 1, sum);
        calculateLevelSum(node.right, level + 1, sum);
    }
}