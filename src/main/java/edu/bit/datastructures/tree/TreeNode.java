package edu.bit.datastructures.tree;

public class TreeNode {
    public TreeNode left;
    public TreeNode right;
    public TreeNode parent;
    public int val;
    private int size = 0;

    public TreeNode(int val) {
        this.val = val;
        left = right = null;
    }

    public boolean isLeaf() {
        return (left == null && right == null);
    }

    private void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    private void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }

    public void insertInOrder(int d) {
        if (d <= val) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    // todo
    public TreeNode insertLevelOrder(Integer[] arr, TreeNode root, int i) {
        // Base case for recursion
        if (i < arr.length) {
            root = new TreeNode(arr[i]);

            // insert left child
            root.left = insertLevelOrder(arr, root.left, (2 * i) + 1);

            // insert right child
            root.right = insertLevelOrder(arr, root.right, (2 * i) + 2);
        }
        return root;
    }
}