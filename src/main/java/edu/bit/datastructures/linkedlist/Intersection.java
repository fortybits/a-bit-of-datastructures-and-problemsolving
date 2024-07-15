package edu.bit.datastructures.linkedlist;

/**
 * Given two linked lists, determine if the two lists intersect. Return the intersecting node.
 * Note that the intersection is defined based on the reference and not the value. That is if the kth
 * node of one list is exact same as jth node of another. They are then intersecting.
 * <p>
 * Constraints:
 * <p>
 * The number of nodes of listA is in the m.
 * The number of nodes of listB is in the n.
 * 1 <= m, n <= 3 * 10^4
 * 1 <= Node.val <= 10^5
 * <p>
 * Follow up: Could you write a solution that runs in O(m + n) time and use only O(1) memory?
 */
public class Intersection {

    private final KthFromLastNode kthFromLastNode = new KthFromLastNode();

    // to return the node of intersection, one would have to traverse both the lists
    public ListNode intersectingLinkedLists(ListNode first, ListNode second) {
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
        longer = kthFromLastNode.getKthNode(longer, Math.abs(result1.size - result2.size));

        // move both the pointers until collision
        while (shorter != longer) {
            shorter = shorter.next;
            longer = longer.next;
        }

        // return either of the two
        return longer;
    }

    private Result getTailAndSize(ListNode list) {
        if (list == null) {
            return null;
        }
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