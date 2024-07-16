package edu.bit.datastructures.linkedlist;

/**
 * Given a singly linked list of size N.
 * Rotate the linked list counter-clockwise by k nodes,
 * where k is a given positive integer smaller than or equal to length of the linked list.
 */
public class RotateLinkedList {

    public ListNode rotate(ListNode head, int k) {
        ListNode link = head;
        while (k > 0 && head.next != null) {
            head = head.next;
            k--;
        }
        ListNode finalHead = head;
        while (head.next != null) {
            head = head.next;
        }
        head.next = link;
        return finalHead;
    }

    // to avoid cycles (traverse by length)
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) return head;
        ListNode dummy = new ListNode(0);
        dummy.next = head;
        ListNode fast = dummy, slow = dummy;

        int i;
        for (i = 0; fast.next != null; i++)//Get the total length
            fast = fast.next;

        for (int j = i - k % i; j > 0; j--) //Get the i-n%i th node
            slow = slow.next;

        fast.next = dummy.next; //Do the rotation
        dummy.next = slow.next;
        slow.next = null;

        return dummy.next;
    }
}