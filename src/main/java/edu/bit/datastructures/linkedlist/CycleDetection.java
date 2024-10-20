package edu.bit.datastructures.linkedlist;

/**
 * Given a circular linked list, implement and algorithm that returns the node at the beginning of the loop.
 * (follow up with removing the loop)
 */
public class CycleDetection {

    // approach of runner and slower pointers works here
    // if they coincide after a certain time, there is a loop detected
    // the position at which they coincide would be at the equal distance from the loop start
    // as much as the loop start would be from the beginning
    public ListNode findBeginningOfLoop(ListNode head) {
        ListNode slow = head;
        ListNode fast = head;

        // to power just the flag this would be sufficient
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Collision spot
            if (slow == fast) {
                break;
            }
        }

        // error checking for the above loop conditions
        if (fast == null || fast.next == null) {
            return null;
        }

        // distance from start and collision spot is equal
        slow = head;
        while (slow != fast) {
            slow = slow.next;
            fast = fast.next;
        }
        return fast;
    }

    public boolean hasCycle(ListNode head) {
        if (head == null) return false;
        ListNode slow = head;
        ListNode fast = head;

        // to power just the flag this would be sufficient
        while (fast.next != null && fast.next.next != null) {
            slow = slow.next;
            fast = fast.next.next;

            // Collision spot
            if (slow == fast) {
                return true;
            }
        }
        return false;
    }
}