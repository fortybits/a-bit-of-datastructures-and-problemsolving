package edu.bit.datastructures.tree;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class VEBTreeTest {

    VEBTree vebTree = new VEBTree(20);

    @Test
    void testVEBTree() {
        Assertions.assertEquals(1, vebTree.high(12));
        Assertions.assertEquals(4, vebTree.low(14));
    }
}