package edu.bit.datastructures.tree;

import edu.bit.datastructures.tree.entity.BSTNode;

public class TreePrefix {

    private boolean recContainsPrefix(String prefixKey, BSTNode<String> tree) {
        // base case
        if (tree == null) return false;

        // test if each node starts with the prefix.
        if (tree.info().startsWith(prefixKey)) {
            return true;
        }
        // recursive case.
        else if (prefixKey.compareTo(tree.info()) < 0)
            return recContainsPrefix(prefixKey, tree.left());
            // recursive case.
        else if (prefixKey.compareTo(tree.info()) > 0)
            return recContainsPrefix(prefixKey, tree.right());
        else {
            return true;
        }
    }
}