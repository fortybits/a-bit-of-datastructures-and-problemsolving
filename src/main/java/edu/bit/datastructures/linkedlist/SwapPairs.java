package edu.bit.datastructures.linkedlist;

/**
 * Given a linked list, swap every two adjacent nodes and return its head.
 * You must solve the problem without modifying the values in the list's nodes (i.e., only nodes themselves may be changed.)
 */
public class SwapPairs {

    // Using recursion we can continue to select the pairs ensuring the pointers are chained on swapped elements
    public ListNode swapPairs(ListNode head) {
        if ((head == null) || (head.next == null)) return head;
        ListNode next = head.next;
        head.next = swapPairs(head.next.next);
        next.next = head;
        return next;
    }
}