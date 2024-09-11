package edu.bit.datastructures.linkedlist;

import java.util.Arrays;
import java.util.List;

/**
 * You are given the heads of two sorted linked lists list1 and list2.
 * <p>
 * Merge the two lists into one sorted list. The list should be made by splicing together the nodes of the first two lists.
 * <p>
 * Return the head of the merged linked list.
 * <p>
 * The number of nodes in both lists is in the range [0, 50].
 * -100 <= Node.val <= 100
 * Both list1 and list2 are sorted in non-decreasing order.
 */
public class MergeSortedLists {

    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode current = new ListNode(Integer.MIN_VALUE);
        ListNode result = current;
        while (list1 != null && list2 != null) {
            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }
            current = current.next;
        }

        while (list1 != null) {
            current.next = list1;
            list1 = list1.next;
            current = current.next;
        }

        while (list2 != null) {
            current.next = list2;
            list2 = list2.next;
            current = current.next;
        }

        return result.next;
    }


    /**
     * You are given an array of k linked-lists lists, each linked-list is sorted in ascending order.
     * <p>
     * Merge all the linked-lists into one sorted linked-list and return it.
     */
    public ListNode mergeKLists(List<ListNode> lists) {
        // if we make use of the identified method above, we can continue to half each iteration
        if (lists.isEmpty()) return null;
        if (lists.size() == 1) return lists.getFirst();
        return mergeTwoLists(mergeKLists(lists.subList(0, lists.size() / 2)),
                mergeKLists(lists.subList(lists.size() / 2, lists.size())));
        // the overall complexity of this code is O(logK) for the divide and conquer
        // and O(N) for each of the merge compute i.e. overall NLogK
    }


    public ListNode mergeKLists(ListNode[] lists) {
        List<ListNode> input = Arrays.stream(lists).toList();
        // if we make use of the identified method above, we can continue to half each iteration
        if (input.isEmpty()) return null;
        if (input.size() == 1) return input.getFirst();
        return mergeTwoLists(mergeKLists(input.subList(0, input.size() / 2).toArray(ListNode[]::new)),
                mergeKLists(input.subList(input.size() / 2, input.size()).toArray(ListNode[]::new)));
        // the overall complexity of this code is O(logK) for the divide and conquer
        // and O(N) for each of the merge compute i.e. overall NLogK
    }
}
