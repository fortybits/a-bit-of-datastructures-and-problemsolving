package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Test;

class KthFromLastNodeTest {

    KthFromLastNode kthFromLastNode = new KthFromLastNode();

    @Test
    void testRemovingKthFromEnd() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        kthFromLastNode.removeNthFromEnd(listNode, 2);
    }

}