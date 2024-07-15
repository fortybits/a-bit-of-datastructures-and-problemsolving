package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class CycleDetectionTest {

    CycleDetection cycleDetection = new CycleDetection();

    @Test
    void testFindBeginningOfLoopWithValidLoop() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = listNode.next.next;
        Assertions.assertEquals(3, cycleDetection.findBeginningOfLoop(listNode).val);
    }

    @Test
    void testFindBeginningOfLoopWithoutLoop() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        Assertions.assertNull(cycleDetection.findBeginningOfLoop(listNode));
    }

    @Test
    void testToDetectCycle() {
        ListNode listNode = new ListNode(4);
        listNode.next = new ListNode(5);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(1);
        listNode.next.next.next.next = listNode.next.next;
        Assertions.assertTrue(cycleDetection.hasCycle(listNode));
    }
}
