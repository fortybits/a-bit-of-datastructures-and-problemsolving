package edu.bit.datastructures.linkedlist;

/**
 * Write code tto partition a linked list around a value x, such that all nodes less than x comes
 * before all the nodes greater than or equal to x. If x is contained within the list,
 * the values of x only need to be after the elements less than x. The partition element x,
 * is a part of list it can appear in the right partition anywhere)
 */
public class PartitionLinkedList {

    // one way is to keep a track of before and after partition values with start and end pointers
    // this would require keeping 4 pointers as beforeStart, beforeEnd, afterStart and afterEnd
    ListNode partitionLinkedListByValue(ListNode head, int x) {
        ListNode beforeStart = null;
        ListNode beforeEnd = null;
        ListNode afterStart = null;
        ListNode afterEnd = null;

        while (head != null) {
            ListNode next = head.next;
            head.next = null;
            // part for smaller values
            if (head.val < x) {
                // decide where to insert the node now
                if (beforeStart == null) {
                    beforeStart = head;
                    beforeEnd = beforeStart;
                } else {
                    beforeEnd.next = head;
                    beforeEnd = head;
                }
            } else { // part for larger values
                if (afterStart == null) {
                    afterStart = head;
                    afterEnd = afterStart;
                } else {
                    afterEnd.next = head;
                    afterEnd = head;
                }
            }
            head = next;
        }
        // nothing fell in the first bucket
        if (beforeStart == null) {
            return afterStart;
        }

        // link the two partitions
        beforeEnd.next = afterStart;
        return beforeStart; // return the reference of the start of the chain
    }

    // you can still optimise the use of variables for tracking the lists
    // if the elements of this list are supposedly not required to be stable
    // we can grow the head and the tail of the list
    ListNode partitionLinkedListByValueOptimised(ListNode node, int x) {
        ListNode head = node;
        ListNode tail = node;
        while (node != null) {
            ListNode next = node.next;
            if (node.val < x) {
                // insert the node at head
                node.next = head;
                head = node;
            } else {
                // grow the tail
                tail.next = node;
                tail = node;
            }
            node = next;
        }
        tail.next = null;
        return head;
    }
}