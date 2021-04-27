package edu.bit.datastructures.linkedlist;

/**
 * Given two linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on the reference and not the value. That is if the kth
 * node of one list is exact same as jth node of another. They are then intersecting.
 */
public class Intersection {

    // to return the node of intersection, one would have to traverse both the lists
    ListNode intersectingLinkedLists(ListNode first, ListNode second) {
        if (first == null || second == null) {
            return null;
        }
        Result result1 = getTailAndSize(first);
        Result result2 = getTailAndSize(second);

        // confirm they are intersecting
        if (result1.tail != result2.tail) {
            return null;
        }

        ListNode shorter = result1.size < result2.size ? first : second;
        ListNode longer = result1.size < result2.size ? second : first;

        // advance the pointer for longer list by the difference in size starting from the tail
        longer = KthFromLastNode.getKthNode(longer, Math.abs(result1.size - result2.size));

        // move both the pointers until collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        // return either of the two
        return longer;
    }

    private Result getTailAndSize(ListNode list) {
        if (list == null) return null;
        int size = 1;
        ListNode current = list;
        while (current.next != null) {
            size++;
            current = current.next;
        }
        return new Result(current, size);
    }

    record Result(ListNode tail, int size) {
    }
}