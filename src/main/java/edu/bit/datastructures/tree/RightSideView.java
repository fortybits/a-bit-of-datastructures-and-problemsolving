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
        List<Integer> result = new ArrayList<>();
        rightSideViewHelper(root, result, 0);
        return result;
    }


    public void rightSideViewHelper(TreeNode curr, List<Integer> result, int currDepth) {
        if (curr == null) {
            return;
        }
        if (currDepth == result.size()) {
            result.add(curr.val);
        }
        if (curr.left == null && curr.right == null) {
            return;
        }

        rightSideViewHelper(curr.right, result, currDepth + 1);
        rightSideViewHelper(curr.left, result, currDepth + 1);
    }
}