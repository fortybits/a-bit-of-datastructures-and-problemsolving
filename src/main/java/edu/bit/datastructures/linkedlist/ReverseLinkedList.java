package edu.bit.datastructures.linkedlist;

/**
 * Created by naman.nigam on 09/02/16.
 */
class ReverseLinkedList {

    // reverses without using any extra space
    static ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null, curr = head, next;
        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        head = prev;
        return head;
    }

    static ListNode reverseLinkedListAndClone(ListNode node) {
        ListNode head = null;
        while (node != null) {
            ListNode next = new ListNode(node.val);
            next.next = node;
            head = next;
            node = node.next;
        }
        return head;
    }
}
