package edu.bit.datastructures.linkedlist;

import java.util.HashSet;
import java.util.Set;

/**
 * Given the head of a linked list and an integer val, remove all the nodes of the linked list that has Node.val == val,
 * and return the new head.
 * <p>
 * The number of nodes in the list is in the range [0, 104].
 * 1 <= Node.val <= 50
 * 0 <= val <= 50
 */
public class RemoveSelectiveValues {

    public ListNode removeElements(ListNode head, int val) {
        if (head == null) {
            return null;
        }

        ListNode start = new ListNode(0);
        start.next = head;

        ListNode current = start;

        while (current.next != null) {
            if (current.next.val == val) {
                current.next = current.next.next;
                // Here cannot move cur to cur.next as we need to validate the next node.
            } else {
                current = current.next;
            }
        }

        return start.next;
    }

    void removeDupes(ListNode head) {
        Set<Integer> set = new HashSet<>();
        ListNode prev = head; // use for deleting the links in a single linked list
        while (head != null) {
            if (set.contains(head.val)) {
                // deleteNode
                prev.next = head.next;
            } else {
                set.add(head.val);
                prev = head;
            }
            head = head.next;
        }
    }

}
