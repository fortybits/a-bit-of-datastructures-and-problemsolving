package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class SumListsTest {

    SumLists sumLists = new SumLists();

    @Test
    void testAddingTwoNumbersInReverseLinkedListRepresentation() {
        // [2,4,3]
        // [5,6,4]
        ListNode listNode1 = new ListNode(2);
        listNode1.next = new ListNode(4);
        listNode1.next.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(6);
        listNode2.next.next = new ListNode(4);

        ListNode listNode = sumLists.addTwoNumbers(listNode1, listNode2);

        Assertions.assertAll(
                () -> Assertions.assertEquals(7, listNode.val),
                () -> Assertions.assertEquals(0, listNode.next.val),
                () -> Assertions.assertEquals(8, listNode.next.next.val),
                () -> Assertions.assertNull(listNode.next.next.next)
        );
    }

    @Test
    void testAddingTwoNumbersWithCarryOverheadInReverseLinkedListRepresentation() {
        // [9,9,9,9,9,9,9]
        // [9,9,9,9]
        ListNode listNode1 = new ListNode(9);
        listNode1.next = new ListNode(9);
        listNode1.next.next = new ListNode(9);
        listNode1.next.next.next = new ListNode(9);
        listNode1.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next = new ListNode(9);
        listNode1.next.next.next.next.next.next = new ListNode(9);

        ListNode listNode2 = new ListNode(9);
        listNode2.next = new ListNode(9);
        listNode2.next.next = new ListNode(9);
        listNode2.next.next.next = new ListNode(9);

        ListNode listNode = sumLists.addTwoNumbers(listNode1, listNode2);

        Assertions.assertAll(
                () -> Assertions.assertEquals(8, listNode.val),
                () -> Assertions.assertEquals(9, listNode.next.val),
                () -> Assertions.assertEquals(9, listNode.next.next.val),
                () -> Assertions.assertEquals(9, listNode.next.next.next.val),
                () -> Assertions.assertEquals(0, listNode.next.next.next.next.val),
                () -> Assertions.assertEquals(0, listNode.next.next.next.next.next.val),
                () -> Assertions.assertEquals(0, listNode.next.next.next.next.next.next.val),
                () -> Assertions.assertEquals(1, listNode.next.next.next.next.next.next.next.val),
                () -> Assertions.assertNull(listNode.next.next.next.next.next.next.next.next)
        );
    }
}

