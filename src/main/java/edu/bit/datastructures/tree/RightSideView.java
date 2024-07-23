package edu.bit.datastructures.tree;

import java.util.ArrayList;
import java.util.List;

/**
 * Given the root of a binary tree, imagine yourself standing on the right side of it,
 * return the values of the nodes you can see ordered from top to bottom.
 * <p>
 * Input: root = [1,2,3,null,5,null,4]
 * Output: [1,3,4]
 * <p>
 * Input: root = [1,null,3]
 * Output: [1,3]
 * <p>
 * Input: root = []
 * Output: []
 * <p>
 * Constraints:
 * The number of nodes in the tree is in the range [0, 100].
 * -100 <= Node.val <= 100
 */
public class RightSideView {

    public List<Integer> rightSideView(TreeNode root) {
        return rightSideViewHelper(root, new ArrayList<>());
    }

    List<Integer> rightSideViewHelper(TreeNode root, List<Integer> list) {
        if (root == null) {
            return new ArrayList<>();
        }
        list.add(root.val);
        if (root.left == null && root.right == null) {
            return list;
        }
        if (root.right == null) {
            return rightSideViewHelper(root.left, list);
        } else {
            return rightSideViewHelper(root.right, list);
        }
    }

    public void rightView(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        if (curr.left == null && curr.right == null) {
            return;
        }

        rightView(curr.right, result, currDepth + 1);
        rightView(curr.left, result, currDepth + 1);
    }
}