package edu.bit.datastructures.linkedlist;

public class ReverseLinkedList {

    // reverses without using any extra space
    public ListNode reverseLinkedList(ListNode head) {
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

    public ListNode reverseLinkedListAndClone(ListNode node) {
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
