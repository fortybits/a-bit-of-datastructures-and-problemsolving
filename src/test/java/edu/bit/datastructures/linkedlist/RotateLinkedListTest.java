package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class RotateLinkedListTest {

    RotateLinkedList rotateLinkedList = new RotateLinkedList();

    @Test
    void testListRotation() {
        ListNode listNode = new ListNode(1);
        listNode.next = new ListNode(2);
        listNode.next.next = new ListNode(3);
        listNode.next.next.next = new ListNode(4);
        listNode.next.next.next.next = new ListNode(5);
        listNode.next.next.next.next.next = new ListNode(6);
        listNode.next.next.next.next.next.next = new ListNode(7);
        listNode.next.next.next.next.next.next.next = new ListNode(8);
        ListNode result = rotateLinkedList.rotate(listNode, 4);
        Assertions.assertEquals(5, result.val);
        Assertions.assertEquals(6, result.next.val);
    }

    @Test
    void testNonSequentialListRotation() {
        ListNode listNode = new ListNode(2);
        listNode.next = new ListNode(4);
        listNode.next.next = new ListNode(7);
        listNode.next.next.next = new ListNode(8);
        listNode.next.next.next.next = new ListNode(9);
        ListNode result = rotateLinkedList.rotate(listNode, 3);
        Assertions.assertEquals(8, result.val);
        Assertions.assertEquals(9, result.next.val);
    }
}