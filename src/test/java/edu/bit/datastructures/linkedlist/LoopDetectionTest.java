package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class LoopDetectionTest {

    LoopDetection loopDetection = new LoopDetection();

    @Test
    void testFindBeginningOfLoopWithValidLoop() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = listNode.next.next;
        Assertions.assertEquals(3, loopDetection.findBeginningOfLoop(listNode).val);
    }

    @Test
    void testFindBeginningOfLoopWithoutLoop() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        Assertions.assertNull(loopDetection.findBeginningOfLoop(listNode));
    }
}
