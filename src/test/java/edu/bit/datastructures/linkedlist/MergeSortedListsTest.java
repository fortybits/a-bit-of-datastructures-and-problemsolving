package edu.bit.datastructures.linkedlist;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

class MergeSortedListsTest {

    MergeSortedLists mergeSortedLists = new MergeSortedLists();

    @Test
    void testMergeSortInList() {
        ListNode listNode1 = new ListNode(-9);
        listNode1.next = new ListNode(3);

        ListNode listNode2 = new ListNode(5);
        listNode2.next = new ListNode(7);

        ListNode listNode = mergeSortedLists.mergeTwoLists(listNode1, listNode2);

        Assertions.assertEquals(-9, listNode.val);
        Assertions.assertEquals(3, listNode.next.val);
        Assertions.assertEquals(5, listNode.next.next.val);
        Assertions.assertEquals(7, listNode.next.next.next.val);
    }

}