package edu.bit.datastructures.tree;

/**
 * Implement a function to check if a given binary tree is a binary search tree
 */
public class ValidateBST {

    private int index = 0;
    // as noticeable, the primary check here is to compare an element with the element added previous
    // to it in array so we could modify the existing solution to reduce the space consumed as
    private Integer lastPrinted = null;

    private void copyBST(TreeNode root, int[] array) {
        if (root == null) {
            return;
        }
        copyBST(root.left, array);
        array[index] = root.val;
        index++;
        copyBST(root.right, array);
    }

    // There are two possible approaches with this -
    // one is to do an in-order traversal and copying the elements into an array, then ensuring that
    // the array is sorted. This takes up around O(N + N) runtime O(N), for each part and the space required
    // for this is also O(N)
    boolean checkBST(TreeNode root) {
        int[] values = new int[100]; // use 'root.size' implementation
        copyBST(root, values);
        for (int i = 1; i < values.length; i++) {
            if (values[i - 1] > values[i]) {
                return false;
            }
        }
        return true;
    }

    private boolean checkBSTOptimised(TreeNode root) {
        if (root == null) {
            return true;
        }
        if (!checkBSTOptimised(root.left)) {
            return false;
        }
        if (lastPrinted != null && root.val <= lastPrinted) {
            return false;
        }
        lastPrinted = root.val;
        return checkBSTOptimised(root.right); // final check
    }


    // another way to approach the problem is to simply compare the data based on the condition
    // left <= data < right
    // the challenge with this is that the condition should hold true for the entire subtree within a node
    public boolean checkBSTWithMinMax(TreeNode node) {
        return checkBSTWithMinMax(node, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    private boolean checkBSTWithMinMax(TreeNode node, Integer min, Integer max) {
        if (node == null) {
            return true;
        }
        return (node.val >= min) && (node.val < max) &&
                checkBSTWithMinMax(node.left, min, node.val) &&
                checkBSTWithMinMax(node.right, node.val, max);
    }
}