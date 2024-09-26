package edu.bit.datastructures.linkedlist;

public class ReverseLinkedList {

    // reverses without using any extra space
    public ListNode reverseLinkedList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;
        ListNode next;
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

    public ListNode reverseList(ListNode head) {
        /* recursive solution */
        return reverseListInt(head, null);
    }

    private ListNode reverseListInt(ListNode head, ListNode newHead) {
        if (head == null)
            return newHead;
        ListNode next = head.next;
        head.next = newHead;
        return reverseListInt(next, head);
    }
}