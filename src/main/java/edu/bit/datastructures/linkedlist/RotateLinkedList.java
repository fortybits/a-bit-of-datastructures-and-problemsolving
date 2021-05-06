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
}